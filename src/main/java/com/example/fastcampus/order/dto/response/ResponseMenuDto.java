package com.example.fastcampus.order.dto.response;

import com.example.fastcampus.order.entity.Menu;
import lombok.Data;

@Data
public class ResponseMenuDto {

    private Long id;
    private String foodName;
    private Long shop;

    public static ResponseMenuDto createResonseMenuDto(Menu menu) {
        ResponseMenuDto responseMenuDto = new ResponseMenuDto();
        responseMenuDto.setId(menu.getId());
        responseMenuDto.setFoodName(menu.getFoodName());
        responseMenuDto.setShop(menu.getShop().getId());

        return responseMenuDto;
    }
}
