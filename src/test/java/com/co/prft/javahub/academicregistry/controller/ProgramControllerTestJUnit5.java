package com.co.prft.javahub.academicregistry.controller;


import com.co.prft.javahub.academicregistry.service.ProgramService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProgramControllerTestJUnit5 {

    @Mock
    private ProgramService programService;

    @InjectMocks
    private ProgramController programController;

    @Test
    void get_whenAll_shouldOk() {
        when(programService.getPrograms()).thenReturn(List.of());
        var response = programController.get();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(List.of(), response.getBody().getData());
    }

}