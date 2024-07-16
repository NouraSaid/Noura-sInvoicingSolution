package com.TRA.tra24Springboot.Repository;

import com.TRA.tra24Springboot.Models.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)

class InventoryRepositoryTest {
    @Autowired
    InventoryRepository inventoryRepository;
    @BeforeEach
    void setUp() {
        Inventory inventory = Inventory.builder()
                .location("Muscat")
                .phoneNumber("99999999")
                .openingHours("8 AM")
                .closingHours("8 PM")
                .build();
        inventoryRepository.save(inventory);

    }


    @Test
    void getInventoryByAvailability() {
        List<Inventory> inventoryAvailability = inventoryRepository.getInventoryByAvailability(Boolean.TRUE);
        assertThat(inventoryAvailability).isNotNull();
        assertThat(inventoryAvailability.size()).isEqualTo(1);
        assertThat(inventoryAvailability.get(0).getIsActive()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void getInventoryByLocation() {
        List<Inventory> inventoryLocations = inventoryRepository.getInventoryByLocation("Sohar");
        assertThat(inventoryLocations).isNotNull();
        assertThat(inventoryLocations.size()).isEqualTo(1);
        assertThat(inventoryLocations.get(0).getLocation()).isEqualTo("Sohar");
    }

    @Test
    void getInventoryByAdminName() {
        List<Inventory> inventoryAdmins = inventoryRepository.getInventoryByAdminName("NOURA");
    assertThat(inventoryAdmins).isNotNull();
    assertThat(inventoryAdmins.size()).isEqualTo(1);
    assertThat(inventoryAdmins.get(0).getAdmin()).isEqualTo("NOURA");
}
}