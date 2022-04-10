package com.example.fastcampus.user.dto.response;

import com.example.fastcampus.user.entity.User;
import lombok.Data;

@Data
public class ResponseUserDto {
    private Long id;
    private String name;
    private Integer userType;
    public static ResponseUserDto createUserDto(User user) {
        ResponseUserDto responseUserDto = new ResponseUserDto();
        responseUserDto.setId(user.getId());
        responseUserDto.setName(user.getName());
        responseUserDto.setUserType(user.getUserType());

        return responseUserDto;

    }
}
