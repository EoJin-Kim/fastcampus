package com.example.fastcampus.order.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class FormDto {
    private String address;
    private Long shop;
    private List<String> menu;
}
