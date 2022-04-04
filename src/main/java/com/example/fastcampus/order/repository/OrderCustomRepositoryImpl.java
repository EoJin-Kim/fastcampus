package com.example.fastcampus.order.repository;

import com.example.fastcampus.order.entity.QShop;
import com.example.fastcampus.order.entity.Shop;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

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
    public void saveShop(Shop shop) {
        em.persist(shop);
    }
}
