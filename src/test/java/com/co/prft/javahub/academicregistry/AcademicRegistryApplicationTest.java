package com.co.prft.javahub.academicregistry;

import com.co.prft.javahub.academicregistry.controller.ProgramController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AcademicRegistryApplicationTest {

    @Autowired
    private ProgramController programController;

    @Test
    void contextLoads() {
        assertNotNull(programController);
    }
}