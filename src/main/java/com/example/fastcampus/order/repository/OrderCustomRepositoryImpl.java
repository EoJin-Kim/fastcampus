package com.example.fastcampus.order.repository;

import com.example.fastcampus.order.entity.Menu;
import com.example.fastcampus.order.entity.Shop;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.fastcampus.order.entity.QMenu.menu;
import static com.example.fastcampus.order.entity.QShop.shop;

@RequiredArgsConstructor
public class OrderCustomRepositoryImpl implements OrderCustomRepository{


    private final EntityManager em;
    private final JPAQueryFactory queryFactory;
    @Override
    public List<Shop> findShopAll() {
        return queryFactory
                .selectFrom(shop)
                .fetch();
    }
    @Override
    public Shop findShopById(Long id) {
        return queryFactory
                .selectFrom(shop)
                .where(shop.id.eq(id))
                .fetchOne();
    }

    @Override
    public void saveShop(Shop shop) {
        em.persist(shop);
    }

    @Override
    public List<Menu> findMenuByShopId(Long shopId) {
        return queryFactory
                .selectFrom(menu)
                .where(menu.shop.id.eq(shopId))
                .fetch();
    }

    @Override
    public void saveMenu(Menu menu) {
        em.persist(menu);
    }


}
