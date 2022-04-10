package com.example.fastcampus.user.controller;

import com.example.fastcampus.user.dto.request.CreateUserDto;
import com.example.fastcampus.user.dto.response.ResponseUserDto;
import com.example.fastcampus.user.entity.User;
import com.example.fastcampus.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user")
    public String getUser(Model model) {
        List<ResponseUserDto> listUser = userService.getAllUser();
        model.addAttribute("user_list", listUser);
        return "user/user_list";
    }
    @PostMapping("/user")
    public String createUser(@RequestBody CreateUserDto userDto) {
        userService.createUser(userDto);
        return "redirect:user";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String name, HttpSession session) {
        User findUser = userService.findUserByName(name);
        session.setAttribute("user_id",findUser.getId());
        System.out.println(session.getAttribute("user_id"));
        return "redirect:/user/user";
    }
}
