package com.example.enumtest.model.business;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String status;
}
