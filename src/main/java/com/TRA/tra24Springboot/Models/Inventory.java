package com.TRA.tra24Springboot.Models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Inventory extends BaseEntity {


        @OneToMany
        private List<Product> products;
        private String location;
        private String admin;
        private String Manager;
        @ElementCollection
        private List<String> workers;
        private String phoneNumber;
        private String openingHours;
        private String closingHours;
        private Boolean isActive;
        List<Supplier> supplier;


        public void setSupplier(String tra) {
        }
}



