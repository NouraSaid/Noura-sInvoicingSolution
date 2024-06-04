package com.TRA.tra24Springboot.DTO;

import com.TRA.tra24Springboot.Models.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDto {
    ProductDetailsDTO productDetailsDTO;

    //method to convert to DTO
    public static ProductDto convertToTDO (Product product){
        ProductDto productDTO = new ProductDto();
        productDTO.setProductDetailsDTO(ProductDetailsDTO.convertToDTOList(product.getProductDetails()));
        return productDTO;
    }

    public static List<ProductDto> convertToDTOList(List<Product> products){
        List<ProductDto> productDTOS = new ArrayList<>();
        for (Product product : products){
            productDTOS.add(convertToTDO(product));
        }
        return productDTOS;
    }

}