package com.example.fastcampus.order.controller;

import com.example.fastcampus.order.dto.request.CreateMenuDto;
import com.example.fastcampus.order.dto.request.CreateShopDto;
import com.example.fastcampus.order.dto.response.ResponseMenuDto;
import com.example.fastcampus.order.dto.response.ResponseShopDto;
import com.example.fastcampus.order.service.OrderService;
import com.example.fastcampus.util.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.fastcampus.util.response.ResponseUtil.*;


@RequiredArgsConstructor
@Controller
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/shops")
    public String shopList(Model model) {
        List<ResponseShopDto> shopDtoList = orderService.getShopList();
        model.addAttribute("shop_list", shopDtoList);
//        ResponseEntity<?> response = getResponse(shopDtoList, Status.SUCCESS);
        return "order/shop_list";

    }
    @PostMapping("/shops")
    public ResponseEntity createShop(@RequestBody CreateShopDto shopDto) {
        ResponseShopDto shop = orderService.createShop(shopDto);
        ResponseEntity<?> response = getResponse(shop, Status.SUCCESS);
        return response;
    }

    @GetMapping("/menus/{shopId}")
    public String menuList(@PathVariable Long shopId, Model model) {
        List<ResponseMenuDto> findMenuDtoList = orderService.getMenuList(shopId);
//        ResponseEntity<?> response = getResponse(findMenuDtoList, Status.SUCCESS);
//        return response;
        model.addAttribute("menu_list", findMenuDtoList);
        return "/order/menu_list";

    }
    @PostMapping("/menus")
    public ResponseEntity createMenu(@RequestBody CreateMenuDto menuDto) {
        ResponseMenuDto menu = orderService.createMenu(menuDto);
        ResponseEntity<?> response = getResponse(menu, Status.SUCCESS);
        return response;
    }
}
