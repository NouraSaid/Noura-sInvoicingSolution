
package com.TRA.tra24Springboot.DTO;

import com.TRA.tra24Springboot.Models.Inventory;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class InventoryDTO {
    List<SupplierDto> suppliers;
    String openingHours;
    String closingHours;
    String phoneNumber;
    String admin;

    public static InventoryDTO convertToDTO(Inventory inventory){
        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setPhoneNumber(inventory.getPhoneNumber());
        inventoryDTO.setOpeningHours(inventory.getOpeningHours());
        inventoryDTO.setClosingHours(inventory.getClosingHours());
        inventoryDTO.setSuppliers(SupplierDto.convertToDtoList(inventory.getSupplier()));

        return inventoryDTO;
    }

    public static List<InventoryDTO> convertToDtoList(List<Inventory> inventories){
        List<InventoryDTO> inventoryDTOs = new ArrayList<>();
        for (Inventory inventory : inventories){
            inventoryDTOs.add(convertToDTO(inventory));
        }
        return inventoryDTOs;
    }
}
