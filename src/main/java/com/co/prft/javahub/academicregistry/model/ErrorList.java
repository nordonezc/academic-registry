package com.co.prft.javahub.academicregistry.model;

import lombok.Data;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Data
public class ErrorList {

    private List<Error> errors;

    @Getter
    public class Error {

        private String errorCode;
        private String errorMessage;
        private OffsetDateTime timestamp;

        public Error(ErrorCode code, String... description) {
            errorCode = code.name();
            errorMessage = code.getDescription().formatted(description);
            timestamp = OffsetDateTime.now(ZoneOffset.UTC);
        }
    }
}