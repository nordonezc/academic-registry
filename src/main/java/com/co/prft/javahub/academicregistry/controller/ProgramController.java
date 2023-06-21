package com.co.prft.javahub.academicregistry.controller;

import com.co.prft.javahub.academicregistry.model.Response;
import com.co.prft.javahub.academicregistry.service.ProgramService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/academic-registry/v1.0.0/programs")
@AllArgsConstructor
public class ProgramController {
    private final ProgramService programService;

    @GetMapping(value = "/all")
    public ResponseEntity<Response> get() {
        return ResponseEntity.ok(new Response().withData(programService.getPrograms()));
    }

}