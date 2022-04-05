package com.example.fastcampus.order.entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @OnDelete(action = OnDeleteAction.CASCADE )
    @JoinColumn(name = "shop_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;


    private LocalDateTime orderDate;

    private String address;

    @Column(columnDefinition = "integer default -1")
    private Integer estimatedTime;

    @Column(columnDefinition = "boolean default false")
    Boolean deliverFinish;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Food> foodList = new ArrayList<>();

    public void setShop(Shop shop) {
        this.shop = shop;
        shop.getOrderList().add(this);
    }

    public static Order createOrder(String address, Shop shop) {
        Order order = new Order();
        order.setAddress(address);
        order.setShop(shop);
        order.setOrderDate(LocalDateTime.now());

        return order;
    }

}
