package com.example.fastcampus.order.controller;

import com.example.fastcampus.order.dto.CreateShopDto;
import com.example.fastcampus.order.entity.Shop;
import com.example.fastcampus.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/shops")
    public List<Shop> shopList() {
        List<Shop> shopList = orderService.getShopList();
        return shopList;
    }

    @PostMapping("/shops")
    public ResponseEntity createShop(@RequestBody CreateShopDto shopDto) {
        Shop shop = orderService.createShop(shopDto);
        return new ResponseEntity<Shop>(shop,HttpStatus.CREATED);
    }

}
