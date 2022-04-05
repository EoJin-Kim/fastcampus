package com.example.fastcampus.order.dto;

import com.example.fastcampus.order.entity.Order;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseOrderDto {

    private Long shop;
    private LocalDateTime orderDate;
    public static ResponseOrderDto createResponseOrderDto(Order createOrder) {
        ResponseOrderDto responseOrderDto = new ResponseOrderDto();
        responseOrderDto.setShop(createOrder.getShop().getId());
        responseOrderDto.setOrderDate(createOrder.getOrderDate());
        return responseOrderDto;
    }
}
