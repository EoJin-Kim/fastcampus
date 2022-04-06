package com.example.fastcampus.boss.controller;

import com.example.fastcampus.order.dto.response.ResponseOrderDto;
import com.example.fastcampus.order.entity.Order;
import com.example.fastcampus.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
@RequestMapping("/boss")
@RequiredArgsConstructor
@Slf4j
public class BossController {

    private final OrderService orderService;
    @GetMapping("/orders/{shopId}")
    public String getOrderList(Model model, @PathVariable Long shopId) {
        List<ResponseOrderDto> findOrderDtoList = orderService.getOrderByShopId(shopId);
        model.addAttribute("order_list", findOrderDtoList);
        return "boss/order_list";
    }

    @PostMapping("/timeinput")
    public String timeInput(@RequestParam Integer estimatedTime,@RequestParam Long orderId) {
        Order chageOrder = orderService.changeEstimatedTime(orderId, estimatedTime);
        log.info("{}",estimatedTime);
        log.info("{}",orderId);
        return "redirect:orders/"+chageOrder.getShop().getId();
    }
}
