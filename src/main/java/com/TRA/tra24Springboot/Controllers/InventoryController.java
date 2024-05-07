package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.User;

import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inventory")

public class InventoryController {

    @PostMapping  ("/details")

    public Inventory receiveStock(@RequestBody Inventory inventoryItem){
        public Inventory globalInventoryItem= new Inventory();
        inventoryItem.setLocation("ASYSAD");
        User manager = new User();
        manager.setName("AHMED SAID ");
        inventoryItem.setManager("manager");
        inventoryItem.setPhoneNumber("94086718");
        inventoryItem.setCreatedDate(new Date());
        inventoryItem.setOpeningHours("6 AM ");
        inventoryItem.setClosingHours("11 PM ");
        inventoryItem.setSupplier("TRA");
        inventoryItem.setIsActive(Boolean.TRUE);

        List<String> workers = new ArrayList<>();
        workers.add("MOHAMED");
        workers.add("SAID");
        inventoryItem.setWorkers(workers);


        globalInventoryItem = inventoryItem;
        return inventoryItem;
    }

    @GetMapping("report")
    public String reportInventory() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("********** Report *************\n");


        List<Product> sortedProducts = globalInventoryItem.getProducts().stream().collect(Collectors.toList());

        // Parse and display sorted product information
        String productsInfo = parseProductsInfo(sortedProducts);
        stringBuilder.append("Sorted Products:\n").append(productsInfo);
        stringBuilder.append("Location: " + globalInventoryItem.getLocation()+"\n");
        stringBuilder.append("Manager: "+globalInventoryItem.getManager()+"\n");
        stringBuilder.append("Supplier: "+globalInventoryItem.getSupplier()+"\n");
        stringBuilder.append("PhonNumber :"+globalInventoryItem.getPhoneNumber()+"\n");
        stringBuilder.append("OpeningHours: "+globalInventoryItem.getOpeningHours()+"\n");
        stringBuilder.append("ClosingHours: "+globalInventoryItem.getClosingHours()+"\n");


        return stringBuilder.toString();
    }

    private String parseProductsInfo(List<Product> products) {
        StringBuilder productsInfo = new StringBuilder();
        for (Product product : products) {
            productsInfo.append("Name: ").append(product.getProductDetails().getName()+"\n");
            productsInfo.append("Country of Origin: ").append(product.getProductDetails().getCountryOfOrigin()+"\n");
            productsInfo.append("Description : ").append(product.getProductDetails().getDescription()+"\n");
            productsInfo.append("Quantity  : ").append(product.getQuantity()+"\n");
            productsInfo.append("category : ").append(product.getCategory()+"\n");
            productsInfo.append("Color  : ").append(product.getProductDetails().getColor()+"\n");
            productsInfo.append("Size : ").append(product.getProductDetails().getSize()+"\n");
            productsInfo.append("sku  : ").append(product.getSku()+"\n");
            productsInfo.append(" price : ").append(product.getProductDetails().getPrice()+"\n");

            productsInfo.append("\n");
        }
        return productsInfo.toString();
    }}
