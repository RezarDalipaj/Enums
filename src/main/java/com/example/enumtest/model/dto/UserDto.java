package com.example.enumtest.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Integer id;
    private String userName;
    private String password;
    private String status;
}
