package com.example.fastcampus.delivery.controller;

import com.example.fastcampus.order.dto.response.ResponseOrderDto;
import com.example.fastcampus.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/delivery")
@RequiredArgsConstructor
public class DeliveryController {

    private final OrderService orderService;
    @GetMapping("/orders")
    public String getAllOrders(Model model) {
        List<ResponseOrderDto> orderList = orderService.getOrderList();
        model.addAttribute("order_list", orderList);
        return "delivery/order_list";
    }

    @PostMapping("/orders")
    public String finishDelivery(@RequestParam Long orderId) {
        orderService.finishDelivery(orderId);
        return "redirect:orders";
    }
}

