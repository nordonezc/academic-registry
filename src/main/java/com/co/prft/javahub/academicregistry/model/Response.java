package com.co.prft.javahub.academicregistry.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@With
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    private Object data;
    private Detail detail;

    public record Detail() {
    }

}