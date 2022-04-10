package com.example.fastcampus.user.service;

import com.example.fastcampus.user.dto.request.CreateUserDto;
import com.example.fastcampus.user.dto.response.ResponseUserDto;
import com.example.fastcampus.user.entity.User;
import com.example.fastcampus.user.repository.UserDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserDataRepository userDataRepository;

    public List<ResponseUserDto> getAllUser() {
        List<User> allUser = userDataRepository.findAll();
        List<ResponseUserDto> collect = allUser.stream()
                .map(user -> ResponseUserDto.createUserDto(user))
                .collect(Collectors.toList());
        return collect;
    }

    public User createUser(CreateUserDto userDto) {
        User createUser = User.createUser(userDto);
        User saveUser = userDataRepository.save(createUser);
        return saveUser;
    }

    public User findUserByName(String name) {
        User user = userDataRepository.findByName(name).get();
        return user;
    }
}
