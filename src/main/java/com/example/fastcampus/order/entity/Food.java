package com.example.fastcampus.order.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Food {
    @Id
    @GeneratedValue
    @Column(name = "food_id")
    private Long id;


    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "order_id")
    @ManyToOne(fetch = FetchType.LAZY)
    Order order;

    String foodName;
}
