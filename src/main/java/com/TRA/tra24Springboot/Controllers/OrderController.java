package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Models.OrderStatus;
import com.TRA.tra24Springboot.Models.PaymentStatus;
import com.TRA.tra24Springboot.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Method to create the order
    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {

        return orderService.createOrder(order);
    }

    // Method to update order
    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order userOrder) {
        return orderService.updateOrder(userOrder);
    }

    // Method to cancel order
    @PutMapping("/cancel/{id}")
    public String cancelOrder(@PathVariable Integer id, @RequestBody Order userOrder) {
        return orderService.cancelOrder(id, userOrder);
    }
}
