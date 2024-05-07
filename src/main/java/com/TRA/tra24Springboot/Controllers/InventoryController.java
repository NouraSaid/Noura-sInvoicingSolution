package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/inventory")

public class InventoryController {

    @PostMapping  ("/details")
    public Inventory getInventotyDetailes(){
        Inventory inventory = new Inventory();
        inventory.setLocation("ASYSAD");

        User manager = new User();
        manager.setName("AHMED SAID ");
        inventory.setManager("manager");
        inventory.setPhoneNumber("94086718");
        inventory.setOpeningHours("6 AM ");
        inventory.setClosingHours("11 PM ");
        inventory.setSupplier("TRA");
       // inventory.setIsActive(t);


        List<String> workers = new ArrayList<>();
        workers.add("MOHAMED");
        workers.add("SAID");
        inventory.setWorkers(workers);


        return inventory;
    }



    @GetMapping("report")
    public String reportInventory() {

        StringBuilder stringBuilder = new StringBuilder();


    return  stringBuilder.toString();    } }
