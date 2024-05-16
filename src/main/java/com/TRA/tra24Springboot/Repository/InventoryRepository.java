package com.TRA.tra24Springboot.Repository;
import com.TRA.tra24Springboot.Models.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;



    public interface InventoryRepository extends JpaRepository <Inventory, Integer> {




    }

