package com.TRA.tra24Springboot.Service;

import com.TRA.tra24Springboot.Models.*;
import com.TRA.tra24Springboot.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier addSupplier() {
        // Create ProductDetails
        ProductDetails productDetails = new ProductDetails();
        productDetails.setId(1);
        productDetails.setName("Apple");
        productDetails.setColor("Green");
        productDetails.setSize("Small");
        productDetails.setPrice(10d);
        productDetails.setCountryOfOrigin("USA");
        productDetails.setDescription("Apple Product");

        // Create Product
        Product product = new Product();
        product.setProductDetails(productDetails);
        product.setSku(UUID.randomUUID());
        product.setCategory("Electronics");
        product.setQuantity(1);
        product.setId(1);
        product.setIsActive(Boolean.TRUE);
        product.setCreatedDate(new Date());

        // Create Order
        Order order = new Order();
        order.setId(01);
        order.setProductsOrdered(Arrays.asList(product));
        order.setCategoryName("Electronics");
        order.setCreatedDate(new Date());
        order.setOrderDate(new Date());
        order.setStatus(OrderStatus.IN_PROGRESS);
        order.setPaymentStatus(PaymentStatus.PAID);
        order.setPaymentType(PaymentType.BANK_TRANSFER);
        order.setDueDate(new Date());

        // Create ContactDetails
        Supplier supplier = getSupplier(order);

        // Save the Supplier using SupplierRepository
        return supplierRepository.save(supplier);
    }

    private static Supplier getSupplier(Order order) {
        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setPhoneNumber("94086718");
        contactDetails.setEmail("noura@tra.com");

        // Create Supplier
        Supplier supplier = new Supplier();
        supplier.setId(10);
        supplier.setCompanyName("Asyad");
        supplier.setCountry("OMAN");
        supplier.setOrders(Arrays.asList(order));
        supplier.setContactDetails(contactDetails);
        supplier.setMinimumOrderQuantity("10");
        supplier.setCreatedDate(new Date());
        supplier.setIsActive(Boolean.TRUE);
        return supplier;
    }

        public String updateSupplier(Integer id) {
            Supplier supplier = supplierRepository.getById(id);
            supplier.setUpdatedDate(new Date());

            supplierRepository.save(supplier);
            return "Updated Successfully";
        }
//    Optional<Supplier> optionalSupplier = supplierRepository.getById(id);
//    if (optionalSupplier.isPresent()) {
//        Supplier existingSupplier = optionalSupplier.get();
//
//
//        existingSupplier.setCompanyName(updatedSupplier.getCompanyName());
//        existingSupplier.setCountry(updatedSupplier.getCountry());
//        existingSupplier.setContactDetails(updatedSupplier.getContactDetails());
//        existingSupplier.setProductsOffered(updatedSupplier.getProductsOffered());
//        existingSupplier.setNextDeliveryTime(updatedSupplier.getNextDeliveryTime());
//        existingSupplier.setExpectedProducts(updatedSupplier.getExpectedProducts());
//        existingSupplier.setComplaints(updatedSupplier.getComplaints());
//        existingSupplier.setPaymentMethods(updatedSupplier.getPaymentMethods());
//        existingSupplier.setShippingMethods(updatedSupplier.getShippingMethods());
//        existingSupplier.setMinimumOrderQuantity(updatedSupplier.getMinimumOrderQuantity());
//        existingSupplier.setOrders(updatedSupplier.getOrders());
////
//
////        return SupplierRepository.save(existingSupplier);
////    } else {
//
//        return null;
//    }
}
