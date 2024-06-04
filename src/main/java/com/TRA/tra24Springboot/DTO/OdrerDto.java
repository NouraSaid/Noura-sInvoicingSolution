package com.TRA.tra24Springboot.DTO;

import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Models.OrderStatus;
import com.TRA.tra24Springboot.Models.PaymentStatus;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class OdrerDto {
    List<ProductDto> productDTO;
    Integer orderID;
    OrderStatus orderStatus;
    PaymentStatus paymentStatus;
    Date orderDate;

    public static OdrerDto convertToDTO(Order order) {
        OdrerDto orderDTO = new OdrerDto();
        orderDTO.setOrderID(order.getId());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setOrderStatus(order.getStatus());
        orderDTO.setPaymentStatus(order.getPaymentStatus());
        orderDTO.setProductDTO(ProductDto.convertToDTOList(order.getProductsOrdered()));

        return orderDTO;
    }

    public static List<OdrerDto> convertToDTOList(List<Order> orders){
        List<OdrerDto> orderDTOS = new ArrayList<>();
        for (Order order:orders){
            orderDTOS.add(convertToDTO(order));
        }
        return orderDTOS;
    }
}