package com.co.prft.javahub.academicregistry.model.program;

import com.co.prft.javahub.academicregistry.model.TraceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ProgramDto extends TraceDto {
    private UUID id;
    private String name;
    private String description;
    private StatusProgram status;
}