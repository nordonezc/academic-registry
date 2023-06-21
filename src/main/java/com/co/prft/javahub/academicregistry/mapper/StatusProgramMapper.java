package com.co.prft.javahub.academicregistry.mapper;

import com.co.prft.javahub.academicregistry.model.program.StatusProgram;
import org.mapstruct.Mapper;

import java.util.Optional;
import java.util.function.Function;

@Mapper
public interface StatusProgramMapper {

    default StatusProgram map(String statusProgram) {
        try{
            return StatusProgram.valueOf(statusProgram);
        }catch (IllegalArgumentException e){
            return StatusProgram.EMPTY;
        }
    }

    default String map(StatusProgram statusProgram) {
        return statusProgram.name();
    }
}