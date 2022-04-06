package com.example.fastcampus.order.repository;

import com.example.fastcampus.order.entity.Menu;
import com.example.fastcampus.order.entity.Order;
import com.example.fastcampus.order.entity.Shop;

import java.util.List;

public interface OrderCustomRepository{
    List<Shop> findShopAll();

    void saveShop(Shop shop);

    List<Menu> findMenuByShopId(Long shopId);

    Shop findShopById(Long shop);

    void saveMenu(Menu menu);

    List<Order> findOrderAll();

    List<Order> findOrderByShopId(Long shopId);
}
