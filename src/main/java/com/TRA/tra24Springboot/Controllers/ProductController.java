package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Service.MailingService;
import com.TRA.tra24Springboot.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
   ProductService productService; // Corrected field name
    @Autowired
    MailingService mailingService;

    @PostMapping("/add")
   public Product addProduct(@RequestBody Product product) {

        return productService.add(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.delete(id);
        return "Product deleted successfully";
    }


@PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.update(product); // Corrected method call
    }

}
