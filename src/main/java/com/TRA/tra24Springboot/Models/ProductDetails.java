package com.TRA.tra24Springboot.Models;

import lombok.Data;

import java.util.Date;

@Data
public class ProductDetails extends BaseEntity{

    String name;
    String countryOfOrigin;
    Date expiryDate;
    String size;
    String color;
    String description;
    Double price;


}
