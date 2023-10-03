package com.co.prft.javahub.academicregistry.controller;


import com.co.prft.javahub.academicregistry.repository.ProgramRepository;
import com.co.prft.javahub.academicregistry.service.ProgramService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * {@link org.springframework.boot.test.context.SpringBootTest} is for initialize the Test Spring Beans
 * {@link org.junit.jupiter.api.TestInstance} to create a single instance
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = ProgramControllerSpringIntegrationTestConfig.class)
class ProgramControllerSpringIntegrationTest {

    @Mock
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