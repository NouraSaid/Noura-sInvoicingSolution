package com.TRA.tra24Springboot.Repository;


import com.TRA.tra24Springboot.Models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ProductrRepositry extends JpaRepository<Inventory, Integer>
 {

}