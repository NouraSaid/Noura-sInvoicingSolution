package com.TRA.tra24Springboot.Service;

import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Models.OrderStatus;
import com.TRA.tra24Springboot.Models.PaymentStatus;
import com.TRA.tra24Springboot.Models.PaymentType;

import com.TRA.tra24Springboot.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {

   @Autowired
   OrderRepository orderRepository;

    public Order createOrder(Order order) {
        // Add product, set dates and statuses
        order.setOrderDate(new Date());
        order.setStatus(OrderStatus.IN_PROGRESS);
        order.setPaymentStatus(PaymentStatus.UNPAID);
        order.setPaymentType(PaymentType.BANK_TRANSFER);
        order.setDueDate(new Date());
        order.setCategoryName("Electronics");
        order.setCreatedDate(new Date());
        return orderRepository.save(order);
    }

    public Order updateOrder(Order userOrder) {
        userOrder.setOrderDate(new Date());
        return orderRepository.save(userOrder);
    }

    public String cancelOrder(Integer id, Order userOrder) {
        if (userOrder != null && userOrder.getStatus() == OrderStatus.IN_PROGRESS) {
            userOrder.setStatus(OrderStatus.CANCELED);
            if (userOrder.getPaymentStatus() == PaymentStatus.PAID) {
                userOrder.setPaymentStatus(PaymentStatus.REFUND);
            }
            orderRepository.save(userOrder);
            return "Order " + id + " cancelled successfully";
        }
        return "Cancellation failed";
    }
}