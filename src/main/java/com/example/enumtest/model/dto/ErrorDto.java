package com.example.enumtest.model.dto;

import lombok.Setter;
import org.springframework.stereotype.Component;
@Component
@Setter
public class ErrorDto {
    private String status;
    private String message;

}
