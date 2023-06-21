package com.co.prft.javahub.academicregistry.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "program", schema = "academicregistry")
public record Program(
        UUID id,
        String name,
        String description,
        String status,
        @Column("created_at") LocalDateTime createdAt,
        @Column("deleted_at") LocalDateTime deletedAt,
        @Column("modified_at") LocalDateTime modifiedAt,
        @Column("is_deleted") Boolean isDeleted
) {

}