create schema if not exists academicregistry;
set search_path to academicregistry;

create table if not exists program
(
    id          uuid PRIMARY KEY    not null,
    name        varchar(250) unique not null,
    description varchar(250)        null,
    status      varchar(250)        not null default 'ACTIVE',
    created_at  timestamp           not null default now(),
    deleted_at  timestamp           null,
    modified_at timestamp           null,
    is_deleted  boolean             not null default false
);

create table if not exists course
(
    id          uuid PRIMARY KEY not null,
    id_program  uuid             NOT NULL,
    status      varchar(100)     not null default 'ACTIVE',
    credits     integer          not null default 4,
    foreign key (id_program) references program (id),
    created_at  timestamp        not null default now(),
    deleted_at  timestamp        null,
    modified_at timestamp        null,
    is_deleted  boolean          not null default false
);

create table if not exists course_prerequisites
(
    id              uuid PRIMARY KEY NOT NULL,
    id_course       uuid             not null,
    id_prerequisite uuid             NOT NULL,
    status          varchar(100)     not null default 'VALID',
    foreign key (id_course) references course (id),
    foreign key (id_prerequisite) references course (id),
    created_at      timestamp        not null default now(),
    deleted_at      timestamp        null,
    modified_at     timestamp        null,
    is_deleted      boolean          not null default false
);

/*USER*/
create table if not exists academic_user
(
    id              uuid PRIMARY KEY not null,
    name            varchar(250)     not null,
    lastname        varchar(250)     not null,
    document_type   varchar(100)     not null,
    document_number varchar(100)     not null,
    birthday        timestamp        null,
    created_at      timestamp        not null default now(),
    deleted_at      timestamp        null,
    modified_at     timestamp        null,
    is_deleted      boolean          not null default false
);

create table if not exists professor
(
    id          uuid PRIMARY KEY not null,
    id_user     uuid             not null,
    FOREIGN KEY (id_user) REFERENCES academic_user (id),
    status      varchar(100)     not null default 'ACTIVE',
    created_at  timestamp        not null default now(),
    deleted_at  timestamp        null,
    modified_at timestamp        null,
    is_deleted  boolean          not null default false
);

create table if not exists student
(
    id              uuid PRIMARY KEY not null,
    id_user         uuid             not null,
    id_program      uuid             not null,
    status          varchar(100)     not null default 'ACTIVE',
    credits_allowed integer          not null default 200,
    FOREIGN KEY (id_user) REFERENCES academic_user (id),
    FOREIGN KEY (id_program) REFERENCES program (id),
    created_at      timestamp        not null default now(),
    deleted_at      timestamp        null,
    modified_at     timestamp        null,
    is_deleted      boolean          not null default false
);

create table if not exists offered_course
(
    id           uuid PRIMARY KEY not null,
    id_course    uuid             not null,
    id_professor uuid             not null,
    status       varchar(100)     not null default 'OPEN',
    schedule     varchar(100)     not null,
    capacity     integer          not null default 40,
    end_date     timestamp        not null,
    foreign key (id_professor) references professor (id),
    foreign key (id_course) references course (id),
    created_at   timestamp        not null default now(),
    deleted_at   timestamp        null,
    modified_at  timestamp        null,
    is_deleted   boolean          not null default false
);

create table if not exists semester
(
    id              uuid PRIMARY KEY not null,
    credits_allowed integer          not null default 20,
    id_student      uuid             not null,
    status          varchar(100)     not null default 'IN PROGRESS',
    end_inscription timestamp        not null,
    FOREIGN KEY (id_student) REFERENCES student (id),
    created_at      timestamp        not null default now(),
    deleted_at      timestamp        null,
    modified_at     timestamp        null,
    is_deleted      boolean          not null default false
);

create table if not exists enrollment
(
    id                uuid PRIMARY KEY not null,
    id_offered_course uuid             not null,
    id_semester       uuid             not null,
    grade             decimal(6, 2)    null,
    FOREIGN KEY (id_semester) REFERENCES semester (id),
    FOREIGN KEY (id_offered_course) REFERENCES offered_course (id),
    created_at        timestamp        not null default now(),
    modified_at       timestamp        null
);

insert into program (id, name, description, status)
values (gen_random_uuid(),
        'Systems engineering',
        'Systems engineering description',
        'ACTIVE');