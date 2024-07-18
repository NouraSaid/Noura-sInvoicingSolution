package com.TRA.tra24Springboot.Service;

import com.TRA.tra24Springboot.DTO.ProductDto;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.ProductDetails;
import com.TRA.tra24Springboot.Repository.ProductDetailsRepository;
import com.TRA.tra24Springboot.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class ProductService {

   @Autowired
   static ProductRepository productRepository;


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
    public List<ProductDto>getProduct() {
        List<Product> products = productRepository.findAll();
        return ProductDto.convertToDTOList(products);
    }

    public Product getProductByID(Integer productID) {
        return productRepository.getProductByID(productID);
    }

    public List<Product> getProductByName(String productName) {
        return productRepository.getProductByName(productName);
    }

    public List<Product> getProductByCountryOfOrigin(String country) {
        return productRepository.getProductByCountryOfOrigin(country);
    }

    public List<Product> getProductBySize(String size) {
        return productRepository.getProductBySize(size);
    }

    public List<Product> getProductByColor(String color) {
        return productRepository.getProductByColor(color);
    }

    public Product getProductBySKU(UUID sku) {
        return productRepository.getProductBySKU(sku);
    }

    public List<Product> getProductByCategory(String category) {
        return productRepository.getProductByCategory(category);
    }

    public List<Product> getProductByPrice(Double price) {
        return productRepository.getProductByPrice(price);
    }

    public List<Product> getProductByAvailability(Boolean isActive) {
        return productRepository.getProductByAvailability(isActive);
    }

    public List<Product> getProductByQuantity(Integer quantity) {
        return productRepository.getProductByQuantity(quantity);
    }

    public static List<Product> getLowStockProducts() {
        List<Product> products = productRepository.findAll();
        List<Product> lowStockProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getQuantity() < 50) {
                lowStockProducts.add(product);
            }
        }
        return lowStockProducts;
    }
}
