package com.co.prft.javahub.academicregistry.controller;


import com.co.prft.javahub.academicregistry.repository.ProgramRepository;
import com.co.prft.javahub.academicregistry.service.ProgramService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * {@link org.springframework.boot.test.context.SpringBootTest} is for initialize the Test Spring Beans
 * {@link TestInstance} to create a single instance
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ProgramControllerSpringUnitTestConfig.class)
class ProgramControllerSpringUnitTest {

    @Autowired
    ProgramRepository programRepository;

    @Autowired
    ProgramService programService;

    @Autowired
    ProgramController programController;

    @Test
    void get_whenAll_shouldOk() {
        when(programRepository.findAllByIsDeletedIsFalse(any())).thenReturn(Page.empty());
        var response = programController.get();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(List.of(), response.getBody().getData());
    }
}