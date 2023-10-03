package com.co.prft.javahub.academicregistry.controller;


import com.co.prft.javahub.academicregistry.mapper.ProgramMapper;
import com.co.prft.javahub.academicregistry.mapper.StatusProgramMapper;
import com.co.prft.javahub.academicregistry.repository.ProgramRepository;
import com.co.prft.javahub.academicregistry.service.ProgramService;
import com.co.prft.javahub.academicregistry.service.impl.ProgramServiceImpl;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;

/**
 * Start Spring container with the configured beans
 */
class ProgramControllerSpringUnitTestConfig {

    @Bean
    ProgramMapper getProgramMapper() {
        return Mappers.getMapper(ProgramMapper.class);
    }

    @Bean
    StatusProgramMapper getStatusProgramMapper() {
        return Mappers.getMapper(StatusProgramMapper.class);
    }

    @Bean
    ProgramRepository getProgramRepository() {
        return Mockito.mock(ProgramRepository.class);
    }

    @Bean
    ProgramService getProgramService(ProgramRepository programRepository, ProgramMapper programMapper) {
        return new ProgramServiceImpl(programRepository, programMapper);
    }

    @Bean
    ProgramController getProgramController(ProgramService programService) {
        return new ProgramController(programService);
    }

}