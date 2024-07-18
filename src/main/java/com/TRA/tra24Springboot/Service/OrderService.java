package com.TRA.tra24Springboot.Service;

import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Models.OrderStatus;
import com.TRA.tra24Springboot.Models.PaymentStatus;
import com.TRA.tra24Springboot.Models.PaymentType;

import com.TRA.tra24Springboot.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public List<Order> getOrderByStatus(OrderStatus orderStatus) throws Exception{
        try {
            List<Order> orders=orderRepository.getOrderByOrderStatus(orderStatus);
            if (orders.isEmpty()){
                throw  new Exception("No Order found with Order status :"+orderStatus);
            }
            return orders;
        }catch (Exception e) {
            throw new Exception("Failed to retrieve orders by Order Status : " + e.getMessage(), e);
        }

    }
    public List<Order> getOrderByPaymentStatus(PaymentStatus paymentStatus) throws  Exception{
        try {
            List<Order> orders = orderRepository.getOrderByPaymentStatus(paymentStatus);
            if (orders.isEmpty()){
                throw  new Exception("No Order found with payment status :"+paymentStatus);
            }
            return orders;
        }catch (Exception e){
            throw  new Exception("Faild to retrieve orders by payment status "+e.getMessage(),e);
        }
    }

    public List<Order> getOrderByPaymentType(PaymentType paymentType) throws Exception {
        try {
            List<Order> orders = orderRepository.getOrderByPaymentType(paymentType);
            if(orders.isEmpty()){
                throw  new Exception("No Orders found with payment Type :"+paymentType);
            }
            return  orders;
        }catch (Exception e){
            throw  new Exception("Faild to retrieve orders by payment type"+e.getMessage(),e);
        }

    }

    public List<Order> getOrderByCategoryName(String categoryName) throws Exception {
        try {
            List<Order> orders = orderRepository.getOrderByCategoryName(categoryName);
            if(orders.isEmpty()){
                throw  new Exception("No Orders found with payment Type :"+categoryName);
            }
            return  orders;
        }catch (Exception e){
            throw  new Exception("Faild to retrieve orders by category Name"+e.getMessage(),e);
        }

    }

   /* public List<Order>getOrderByIsActive(Boolean isActive) throws  Exception{
        try {
            List<Order> orders = orderRepository.findByOrderByIsActive(isActive);
            if(orders.isEmpty()){
                throw  new Exception("No orders found with isActive: " + isActive);
            }
            return  orders;
        }catch (Exception e){
            throw new Exception("Failed to retrieve orders With isActive : " + e.getMessage(), e);
        }

    }*/
}