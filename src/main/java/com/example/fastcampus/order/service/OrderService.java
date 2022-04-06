package com.example.fastcampus.order.service;

import com.example.fastcampus.order.dto.response.ResponseOrderDto;
import com.example.fastcampus.order.dto.request.CreateMenuDto;
import com.example.fastcampus.order.dto.request.CreateShopDto;
import com.example.fastcampus.order.dto.request.FormDto;
import com.example.fastcampus.order.dto.response.ResponseMenuDto;
import com.example.fastcampus.order.dto.response.ResponseShopDto;
import com.example.fastcampus.order.entity.Food;
import com.example.fastcampus.order.entity.Menu;
import com.example.fastcampus.order.entity.Order;
import com.example.fastcampus.order.entity.Shop;
import com.example.fastcampus.order.repository.OrderDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderDataRepository orderRepository;

    public List<ResponseShopDto> getShopList() {
        List<Shop> shopAll = orderRepository.findShopAll();
        List<ResponseShopDto> responseShopDtoList = shopAll.stream()
                .map(shop -> ResponseShopDto.createResonseShopDto(shop))
                .collect(Collectors.toList());
        return responseShopDtoList;
    }

    public ResponseShopDto createShop(CreateShopDto shopDto) {
        Shop shop = Shop.createShop(shopDto.getShopName(), shopDto.getShopAddress());
        orderRepository.saveShop(shop);
        ResponseShopDto resonseShopDto = ResponseShopDto.createResonseShopDto(shop);
        return resonseShopDto;
    }

    public List<ResponseMenuDto> getMenuList(Long shopId) {
        List<Menu> menuAll = orderRepository.findMenuByShopId(shopId);
        List<ResponseMenuDto> responseShopDtoList = menuAll.stream()
                .map(menu -> ResponseMenuDto.createResonseMenuDto(menu))
                .collect(Collectors.toList());
        return responseShopDtoList;
    }

    public ResponseMenuDto createMenu(CreateMenuDto menuDto) {
        Shop findShop = orderRepository.findShopById(menuDto.getShop());
        Menu createMenu = Menu.createMenu(findShop, menuDto);
        orderRepository.flush();
//        orderRepository.saveMenu(createMenu);
        ResponseMenuDto resonseMenuDto = ResponseMenuDto.createResonseMenuDto(createMenu);
        return resonseMenuDto;
    }

    public ResponseOrderDto createOrder(FormDto formDto) {
//        String address = request.getParameter("address");
        String address = formDto.getAddress();
//        Long shopId = Long.parseLong(request.getParameter("shop"));
        Long shopId = formDto.getShop();
        Shop findShop = orderRepository.findShopById(shopId);
//        String menuTotal = request.getParameter("menu");
//        String[] menus = menuTotal.split(",");
        Order createOrder = Order.createOrder(address, findShop);
        List<String> menuList = formDto.getMenu();
        menuList.stream()
                .map(menu -> Food.createFood(createOrder,menu))
                .forEach(food -> createOrder.getFoodList().add(food));

        ResponseOrderDto responseOrderDto = ResponseOrderDto.createResponseOrderDto(createOrder);
        return responseOrderDto;
    }

    public List<ResponseOrderDto> getOrderList() {
        List<Order> orderAll = orderRepository.findOrderAll();
        List<ResponseOrderDto> collect = orderAll.stream()
                .map(order -> ResponseOrderDto.createResponseOrderDto(order))
                .collect(Collectors.toList());
        return collect;

    }

    public Order changeEstimatedTime(Long orderId, Integer estimatedTime) {
        Order findOrder = orderRepository.findById(orderId).get();
        findOrder.setEstimatedTime(estimatedTime);
        return findOrder;
    }

    public List<ResponseOrderDto> getOrderByShopId(Long shopId) {
        List<Order> orderAll = orderRepository.findOrderByShopId(shopId);
        List<ResponseOrderDto> collect = orderAll.stream()
                .map(order -> ResponseOrderDto.createResponseOrderDto(order))
                .collect(Collectors.toList());
        return collect;
    }
}
