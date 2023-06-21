package com.co.prft.javahub.academicregistry.model;

import lombok.Getter;

@Getter
public enum ErrorCode {

    COURSE_FULL("The course that you are trying to enroll is full");

    String description;

    ErrorCode(String description) {
        this.description = description;
    }

}