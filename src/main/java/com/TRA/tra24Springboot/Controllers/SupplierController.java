package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Models.Supplier;
import com.TRA.tra24Springboot.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService; // Autowire SupplierService

    // Endpoint to add a new supplier
    @PostMapping("/add")
    public Supplier addSupplier() {
        return supplierService.addSupplier();
    }



//    @DeleteMapping("/delete/{id}")
//    public void deleteSupplier(@PathVariable int id) {
//        supplierService.deleteSupplier(id);
//    }



    @PutMapping("/update/{id}")
    public String updateSupplier(@RequestParam Integer id) {
        return supplierService.updateSupplier(id);
    }
}