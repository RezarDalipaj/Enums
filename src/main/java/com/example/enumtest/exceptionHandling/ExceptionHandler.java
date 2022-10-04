package com.example.enumtest.exceptionHandling;

import com.example.enumtest.customException.BadRequestException;
import com.example.enumtest.model.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import javax.naming.AuthenticationException;
@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> handleNullPointerException(NullPointerException nullPointerException){
        ErrorDto errorDto = new ErrorDto();
        if (nullPointerException.getMessage() == null)
            errorDto.setMessage("DATA NOT FOUND");
        else
            errorDto.setMessage(nullPointerException.getMessage() + " NOT FOUND");
        errorDto.setStatus("NOT_FOUND");
        return  ResponseEntity.status(404).body(errorDto);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorDto> handleAuthenticationException(){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("You are not authorized to access this API");
        errorDto.setStatus("UNAUTHORIZED");
        return  ResponseEntity.status(401).body(errorDto);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDto> handleBadRequestException(BadRequestException badRequestException){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(badRequestException.getMessage());
        errorDto.setStatus("BAD_REQUEST");
        return  ResponseEntity.status(400).body(errorDto);
    }
}
