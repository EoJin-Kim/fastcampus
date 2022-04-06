package com.example.fastcampus.order.dto.response;

import com.example.fastcampus.order.entity.Order;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseOrderDto {

    private Long shop;
    private Long orderId;
    private LocalDateTime orderDate;
    private List<String> foodList;
    private Integer estimatedTime;
    private Boolean deliverFinish;
    public static ResponseOrderDto createResponseOrderDto(Order createOrder) {
        ResponseOrderDto responseOrderDto = new ResponseOrderDto();
        responseOrderDto.setOrderId(createOrder.getId());
        responseOrderDto.setShop(createOrder.getShop().getId());
        responseOrderDto.setDeliverFinish(createOrder.getDeliverFinish());
        ArrayList<String> foodList = new ArrayList<>();
        responseOrderDto.setOrderDate(createOrder.getOrderDate());
        createOrder.getFoodList().stream()
                .forEach(food -> foodList.add(food.getFoodName()));
        responseOrderDto.setFoodList(foodList);
        responseOrderDto.setEstimatedTime(createOrder.getEstimatedTime());
        return responseOrderDto;
    }
}
