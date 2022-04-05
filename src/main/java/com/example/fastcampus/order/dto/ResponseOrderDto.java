package com.example.fastcampus.order.dto;

import com.example.fastcampus.order.entity.Order;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseOrderDto {

    private Long shop;
    private LocalDateTime orderDate;
    private List<String> foodList;
    private Integer estimatedTime;
    public static ResponseOrderDto createResponseOrderDto(Order createOrder) {
        ResponseOrderDto responseOrderDto = new ResponseOrderDto();
        responseOrderDto.setShop(createOrder.getShop().getId());
        ArrayList<String> foodList = new ArrayList<>();
        responseOrderDto.setOrderDate(createOrder.getOrderDate());
        createOrder.getFoodList().stream()
                .forEach(food -> foodList.add(food.getFoodName()));
        responseOrderDto.setEstimatedTime(createOrder.getEstimatedTime());
        return responseOrderDto;
    }
}
