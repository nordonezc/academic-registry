package com.co.prft.javahub.academicregistry.controller;


import com.co.prft.javahub.academicregistry.service.ProgramService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class ProgramControllerTestJUnit4 {

    private ProgramService programService;

    private ProgramController programController;

    @BeforeEach
    void init() {
        this.programService = Mockito.mock(ProgramService.class);
        this.programController = new ProgramController(this.programService);
    }

    @Test
    void get_whenAll_shouldOk() {
        when(programService.getPrograms()).thenReturn(List.of());
        var response = programController.get();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(List.of(), response.getBody().getData());
    }

}