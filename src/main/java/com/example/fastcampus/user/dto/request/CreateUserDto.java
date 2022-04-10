package com.example.fastcampus.user.dto.request;

import lombok.Data;

@Data
public class CreateUserDto {
    private String name;
    private Integer userType;

}
