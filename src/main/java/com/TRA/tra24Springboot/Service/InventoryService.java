package com.TRA.tra24Springboot.Service;

import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Models.Invoice;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    private Inventory globalInventoryItem;

    public Inventory receiveStock(Inventory inventoryItem) {
        globalInventoryItem = new Inventory();  // Initialize globalInventoryItem
        globalInventoryItem.setLocation("ASYSAD");
        User manager = new User();
        manager.setName("AHMED SAID");
        globalInventoryItem.setManager(manager.getName());
        globalInventoryItem.setPhoneNumber("94086718");
        globalInventoryItem.setCreatedDate(new Date());
        globalInventoryItem.setOpeningHours("6 AM");
        globalInventoryItem.setClosingHours("11 PM");
        //globalInventoryItem.setSupplier("TRA");
        globalInventoryItem.setIsActive(Boolean.TRUE);

        List<String> workers = new ArrayList<>();
        workers.add("MOHAMED");
        workers.add("SAID");
        globalInventoryItem.setWorkers(workers);

        return globalInventoryItem;
    }

    public String reportInventory() {
        if (globalInventoryItem == null) {
            return "No inventory data available.";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("********** Report *************\n");

        List<Product> sortedProducts = globalInventoryItem.getProducts().stream().collect(Collectors.toList());

        // Parse and display sorted product information
        String productsInfo = parseProductsInfo(sortedProducts);
        stringBuilder.append("Sorted Products:\n").append(productsInfo);
        stringBuilder.append("Location: ").append(globalInventoryItem.getLocation()).append("\n");
        stringBuilder.append("Manager: ").append(globalInventoryItem.getManager()).append("\n");
        stringBuilder.append("Supplier: ").append(globalInventoryItem.getSupplier()).append("\n");
        stringBuilder.append("PhoneNumber: ").append(globalInventoryItem.getPhoneNumber()).append("\n");
        stringBuilder.append("OpeningHours: ").append(globalInventoryItem.getOpeningHours()).append("\n");
        stringBuilder.append("ClosingHours: ").append(globalInventoryItem.getClosingHours()).append("\n");

        return stringBuilder.toString();
    }

    private String parseProductsInfo(List<Product> products) {
        StringBuilder productInfo = new StringBuilder();
        for (Product product : products) {
            productInfo.append("Product ID: ").append(product.getId()).append("\n");
            productInfo.append("Quantity: ").append(product.getQuantity()).append("\n");
            productInfo.append("-------------------------\n");
        }
        return productInfo.toString();
    }

}