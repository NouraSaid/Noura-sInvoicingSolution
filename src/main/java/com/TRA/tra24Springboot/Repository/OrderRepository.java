package com.TRA.tra24Springboot.Repository;

import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Models.OrderStatus;
import com.TRA.tra24Springboot.Models.PaymentStatus;
import com.TRA.tra24Springboot.Models.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT o FROM Order o WHERE o.id = :orderId")
    Order getOrderById(@Param("orderId") Integer orderId);

    @Query(value = "SELECT o FROM Order o WHERE o.categoryName = :categoryName")
    List<Order> getOrderByCategoryName(@Param("categoryName") String categoryName);

    @Query("SELECT o FROM Order o WHERE o.status = :orderStatus")
    List<Order> getOrderByOrderStatus(@Param("orderStatus") OrderStatus orderStatus);

    @Query("SELECT o FROM Order o WHERE o.paymentStatus = :paymentStatus")
    List<Order> getOrderByPaymentStatus(@Param("paymentStatus") PaymentStatus paymentStatus);

    @Query("SELECT o FROM Order o WHERE o.paymentType = :paymentType")
    List<Order> getOrderByPaymentType(@Param("paymentType") PaymentType paymentType);


}
