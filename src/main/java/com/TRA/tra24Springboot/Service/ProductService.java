package com.TRA.tra24Springboot.Service;

import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.ProductDetails;
import com.TRA.tra24Springboot.Repository.ProductDetailsRepository;
import com.TRA.tra24Springboot.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

   @Autowired
   ProductRepository productRepository;


    @Autowired
    ProductDetailsRepository productDetailsRepository;

    public Product add(Product product) {
        ProductDetails productDetails = new ProductDetails();
        productDetails.setName("Apple");
        productDetails.setColor("Green");
        productDetails.setSize("Small");
        productDetails.setPrice(10d);
        productDetails.setCountryOfOrigin("USA");
        productDetails.setDescription("Apple Product");

        productDetails = productDetailsRepository.save(productDetails);

        product.setProductDetails(productDetails);
        product.setSku(UUID.randomUUID());
        product.setCategory("Electronics");
        product.setQuantity(1);
        product.setIsActive(Boolean.TRUE);
        product.setCreatedDate(new Date());

        return productRepository.save(product);
    }

    public String delete(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setIsActive(Boolean.FALSE);
            System.out.println(product.toString());
            productRepository.save(product); // Fixed the repository call here
            return "Deleted Successfully";
        } else {
            return "Product with ID " + id + " not found.";
        }
    }

    public Product update(Product updatedProduct) {


        Optional <Product> optionalProduct = productRepository.findById(updatedProduct.getId());

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();

            existingProduct.setProductDetails(updatedProduct.getProductDetails());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setQuantity(updatedProduct.getQuantity());
            existingProduct.setIsActive(updatedProduct.getIsActive());
            existingProduct.setUpdatedDate(new Date());

            return productRepository.save(existingProduct);
        } else {

            throw new IllegalArgumentException("Product with ID " + updatedProduct.getId() + " not found.");
        }
    }
}