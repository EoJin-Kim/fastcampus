package com.example.fastcampus.order.service;

import com.example.fastcampus.order.dto.CreateShopDto;
import com.example.fastcampus.order.entity.Shop;
import com.example.fastcampus.order.repository.OrderDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderDataRepository orderRepository;

    public List<Shop> getShopList() {
        List<Shop> shopAll = orderRepository.findShopAll();
        return orderRepository.findShopAll();
    }

    public Shop createShop(CreateShopDto shopDto) {
        Shop shop = Shop.createShop(shopDto.getShopName(), shopDto.getShopAddress());
        orderRepository.saveShop(shop);
        return shop;
    }
}
