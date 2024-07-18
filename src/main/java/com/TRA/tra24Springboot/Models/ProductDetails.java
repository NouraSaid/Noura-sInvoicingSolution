package com.TRA.tra24Springboot.Models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetails extends BaseEntity{


        private String name;
        private String color;
        private String countryOfOrigin;
        private Double price;
        private String size;

    public void setDescription(String appleProduct) {
    }

    public char[] getDescription() {

        return new char[0];
    }
}


