package com.TRA.tra24Springboot.DTO;

import com.TRA.tra24Springboot.Models.Supplier;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SupplierDto {
    Integer supplierID;
    String companyName;
    List<OdrerDto> orderDTOs;


    public static SupplierDto convertToDTO(Supplier supplier){
        SupplierDto supplierDTO = new SupplierDto();
        supplierDTO.setSupplierID(supplier.getId());
        supplierDTO.setCompanyName(supplier.getCompanyName());
        supplierDTO.setOrderDTOs(OdrerDto.convertToDTOList(supplier.getOrders()));
        return supplierDTO;
    }

    public static List<SupplierDto> convertToDtoList(List<Supplier> suppliers){
        List<SupplierDto> supplierDTOS = new ArrayList<>();
        for (Supplier supplier : suppliers){
            supplierDTOS.add(convertToDTO(supplier));
        }
        return supplierDTOS;
    }
}