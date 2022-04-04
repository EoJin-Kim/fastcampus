package com.example.fastcampus.order.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Shop {
    @Id
    @GeneratedValue
    @Column(name = "shop_id")
    private Long id;

    private String shopName;

    private String shopAddress;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Menu> menuList = new ArrayList<>();

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orderList = new ArrayList<>();

    public static Shop createShop(String shopName, String shopAddress) {
        Shop shop = new Shop();
        shop.setShopName(shopName);
        shop.setShopAddress(shopAddress);
        return shop;
    }

}
