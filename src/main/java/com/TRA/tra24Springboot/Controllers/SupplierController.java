package com.TRA.tra24Springboot.Controllers;


import com.TRA.tra24Springboot.Models.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;


@RestController
@RequestMapping("/supplier")

public class SupplierController {
    public Supplier globalSupplier = new Supplier();

    @PostMapping("add")
    public Supplier appSupplier() {

        ProductDetails productDetails = new ProductDetails();
        productDetails.setId(1);
        productDetails.setName("Apple");
        productDetails.setColor("Green");
        productDetails.setSize("Small");
        productDetails.setPrice(10d);
        productDetails.setCountryOfOrigin("USA");
        productDetails.setDescription("Apple Product");

        Product product = new Product();
        product.setProductDetails(productDetails);
        product.setSku(UUID.randomUUID());
        product.setCategory("Electronics");
        product.setQuantity(1);
        product.setId(1);
        product.setIsActive(Boolean.TRUE);
        product.setCreatedDate(new Date());

        Order order = new Order();
        order.setId(01);
        order.setProductsOrdered(Arrays.asList(product)); //setting the products lists
        order.setCategoryName("Electronics");
        order.setCreatedDate(new Date());
        order.setOrderDate(new Date());
        order.setStatus(OrderStatus.IN_PROGRESS);
        order.setPaymentStatus(PaymentStatus.PAID);
        order.setPaymentType(PaymentType.BANK_TRANSFER);
        order.setDueDate(new Date());

        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setPhoneNumber("94086718");
        contactDetails.setEmail("noura@tra.com");


        Supplier supplier = new Supplier();
        supplier.setId(10);
        supplier.setCompanyName("Asyad");
        supplier.setCountry("OMAN");
        supplier.setOrders(Arrays.asList(order));
        supplier.setContactDetails(contactDetails);
        supplier.setMinimumOrderQuantity("10");
        supplier.setCreatedDate(new Date());
        supplier.setIsActive(Boolean.TRUE);

        globalSupplier = supplier;
        return supplier;
    }




}
