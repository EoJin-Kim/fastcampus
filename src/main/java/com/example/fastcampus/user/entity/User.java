package com.example.fastcampus.user.entity;

import com.example.fastcampus.user.dto.request.CreateUserDto;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    private String name;
    private Integer userType;

    public static User createUser(CreateUserDto userDto) {
        User user = new User();
        user.setUserType(userDto.getUserType());
        user.setName(userDto.getName());
        return user;
    }
}
