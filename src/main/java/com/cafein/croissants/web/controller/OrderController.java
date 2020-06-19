package com.cafein.croissants.web.controller;

import com.cafein.croissants.web.controller.dto.OrderRequestDto;
import com.cafein.croissants.web.controller.dto.PointRequestDto;
import com.cafein.croissants.web.dao.domain.Client;
import com.cafein.croissants.web.dao.domain.Order;
import com.cafein.croissants.web.dao.domain.Owner;
import com.cafein.croissants.web.dao.domain.Store;
import com.cafein.croissants.web.service.ClientService;
import com.cafein.croissants.web.service.OrderService;
import com.cafein.croissants.web.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private ClientService clientService;

    @PostMapping("/order/android/new")  // new order
    public ResponseEntity<Client> newOrder(@RequestBody OrderRequestDto requestDto){
        orderService.newOrder(requestDto);
        clientService.minusPoint(requestDto.getClient_id(), requestDto.getPoint());
        Client client = clientService.findByEmail(requestDto.getEmail());

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    // AD client에게 자신의 주문 내역 보내주기
    @GetMapping("/order/android/myOrderList/{clientId}") //Android - 나의 주문 내역 정보 보내주기
    public ResponseEntity<List<Order>> getClientOrderList(@PathVariable Integer clientId, Model model) {
        List<Order> orders = orderService.findClientOrder(clientId);
        model.addAttribute("orders", orders);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // AD owner에게 전체 주문 정보 보내주기
    @GetMapping("/order/android/storeOrderList/{storeId}") // web - 나의 가게 주문 내역 정보 보내주기
    public ResponseEntity<List<Order>> getAndOwnerOrderList(@PathVariable Integer storeId, Model model) {
        List<Order> orders = orderService.findOwnerOrder(storeId);
        model.addAttribute("orders", orders);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // AD owner에게 제조 완료 정보 보내주기
    @GetMapping("/order/android/status/{orderId}") // web - 나의 가게 주문 내역 정보 보내주기
    public ResponseEntity<List<Order>> updateStatus(@PathVariable Integer orderId, Model model) {
        orderService.updateStatus(orderId);
        List<Order> orders = orderService.findUpdateOrder(orderId);
        model.addAttribute("orders", orders);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // Web owner에게 전체 주문 내역 보내주기
    @GetMapping("/orderlist") // web - 나의 가게 주문 내역 정보 보내주기
    public String getOrderList(Model model, HttpSession session) {
        Owner owner = (Owner) session.getAttribute("login");
        if(owner == null) {
            return "redirect:/login";
        }
        List<Store> stores = storeService.findAll(owner.getId());
        model.addAttribute("stores", stores);

        return "orderlist";
    }
    @GetMapping("/orderdetail/{storeId}") // web - 나의 가게 주문 내역 정보 보내주기
    public String getOrderListDetail(@PathVariable Integer storeId, Model model, HttpSession session) {
        Owner owner = (Owner) session.getAttribute("login");
        if(owner == null) {
            return "redirect:/login";
        }
        List<Order> orders = orderService.findStoreOrder(storeId);
        model.addAttribute("orders", orders);

        return "orderlist-detail";
    }
}
