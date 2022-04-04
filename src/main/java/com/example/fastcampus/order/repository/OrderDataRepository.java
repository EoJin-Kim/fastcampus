package com.example.fastcampus.order.repository;

import com.example.fastcampus.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface OrderDataRepository extends JpaRepository<Order, Long> ,OrderCustomRepository{

}
