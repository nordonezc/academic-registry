package com.co.prft.javahub.academicregistry.mapper;

import com.co.prft.javahub.academicregistry.entity.Program;
import com.co.prft.javahub.academicregistry.model.program.ProgramDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = {StatusProgramMapper.class})
public interface ProgramMapper {

    ProgramDto map(Program program);

    Program map(ProgramDto program);

}