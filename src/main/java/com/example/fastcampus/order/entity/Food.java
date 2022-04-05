package com.example.fastcampus.order.entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
public class Food {
    @Id
    @GeneratedValue
    @Column(name = "food_id")
    private Long id;


    @JoinColumn(name = "order_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Order order;


    String foodName;

    public void setOrder(Order order) {
        this.order = order;
        order.getFoodList().add(this);
    }

    public static Food createFood(Order order, String menu) {
        Food food = new Food();
        food.setOrder(order);
        food.setFoodName(menu);
        return food;
    }
}
