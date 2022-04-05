package com.example.fastcampus.order.entity;

import com.example.fastcampus.order.dto.request.CreateMenuDto;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
public class Menu {
    @Id
    @GeneratedValue
    @Column(name = "menu_id")
    private Long id;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "shop_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    private String foodName;

    public static Menu createMenu(Shop findShop, CreateMenuDto menuDto) {
        Menu menu = new Menu();
        menu.setShop(findShop);
        menu.setFoodName(menuDto.getFoodName());
        return menu;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
        shop.getMenuList().add(this);
    }
}
