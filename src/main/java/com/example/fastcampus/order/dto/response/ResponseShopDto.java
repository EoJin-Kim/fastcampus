package com.example.fastcampus.order.dto.response;

import com.example.fastcampus.order.entity.Shop;
import lombok.Data;

@Data
public class ResponseShopDto {
    private Long id;
    private String shopName;

    private String shopAddress;

    public static ResponseShopDto createResonseShopDto(Shop shop) {
        ResponseShopDto responseShopDto = new ResponseShopDto();
        responseShopDto.setId(shop.getId());
        responseShopDto.setShopName(shop.getShopName());
        responseShopDto.setShopAddress(shop.getShopAddress());
        return responseShopDto;
    }
}
