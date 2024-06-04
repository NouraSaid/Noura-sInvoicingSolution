package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Service.InventoryService;
import com.TRA.tra24Springboot.Service.SlackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;
    @Autowired
    SlackService slackService;

    @PostMapping("/receive")
    public Inventory receiveStock(@RequestBody Inventory inventoryItem) {
        return inventoryService.receiveStock(inventoryItem);
    }

    @GetMapping("/report")
    public String reportInventory() {
        return inventoryService.reportInventory();
    }

@GetMapping("messages")
public void sendMessage(){
    slackService.sendMessage("", "");
}}
