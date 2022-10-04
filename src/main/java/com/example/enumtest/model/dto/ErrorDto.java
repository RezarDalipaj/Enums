package com.example.enumtest.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ErrorDto {
    private String status;
    private String message;
}
