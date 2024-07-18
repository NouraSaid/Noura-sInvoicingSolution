package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Models.Invoice;
import com.TRA.tra24Springboot.Service.InventoryService;
import com.TRA.tra24Springboot.Service.SlackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private SlackService slackService;

    @PostMapping("/receive")
    public ResponseEntity<Object> receiveStock(@RequestBody Inventory inventoryItem) {
        try {
            return ResponseEntity.ok(inventoryService.receiveStock(inventoryItem));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to receive stock: " + e.getMessage());
        }
    }

    @GetMapping("/report")
    public ResponseEntity<Object> reportInventory() {
        try {
            return ResponseEntity.ok(inventoryService.reportInventory());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to generate inventory report: " + e.getMessage());
        }
    }



    @GetMapping("/messages")
    public ResponseEntity<Object> sendMessage() {
        try {
            slackService.sendMessage("practice", "hi");
            return ResponseEntity.ok("Message sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send message: " + e.getMessage());
        }
    }
}