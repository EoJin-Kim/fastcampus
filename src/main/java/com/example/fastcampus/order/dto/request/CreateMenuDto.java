package com.example.fastcampus.order.dto.request;

import lombok.Data;

@Data
public class CreateMenuDto {
    private Long shop;
    private String foodName;
}
