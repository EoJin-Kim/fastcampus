package com.example.fastcampus.order.repository;

import com.example.fastcampus.order.entity.Shop;

import java.util.List;

public interface OrderCustomRepository{
    List<Shop> findShopAll();

    void saveShop(Shop shop);
}
