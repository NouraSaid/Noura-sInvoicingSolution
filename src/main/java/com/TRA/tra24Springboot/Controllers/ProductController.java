package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Service.MailingService;
import com.TRA.tra24Springboot.Service.ProductService;
import com.TRA.tra24Springboot.Service.SlackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    @GetMapping("/checkStock")
    public List<Product> getLowStockReport() {

        List<Product> lowStockProducts = productService.getLowStockProducts();
        if (!lowStockProducts.isEmpty()) {
            StringBuilder messageBuilder = new StringBuilder();
            messageBuilder.append("Low stock alert:\n");
            for (Product product : lowStockProducts) {
                messageBuilder.append("Product: ").append(product.getProductDetails().getName())
                        .append(", Quantity: ").append(product.getQuantity()).append("\n");
            }
            SlackService.sendMessage("practice", messageBuilder.toString());
        }
        return lowStockProducts;
    }

}

