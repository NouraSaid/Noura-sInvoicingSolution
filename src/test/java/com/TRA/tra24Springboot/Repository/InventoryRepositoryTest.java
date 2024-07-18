package com.TRA.tra24Springboot.Repository;

import com.TRA.tra24Springboot.Models.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)

class InventoryRepositoryTest {
    @Autowired
    InventoryRepository inventoryRepository;
    @BeforeEach
    void setUp() {
        Inventory inventory = Inventory.builder()
                .location("Sohar")
                .Manager("Noura")
                .phoneNumber("94086718")
                .openingHours("6 AM")
                .closingHours("10 PM")
                .build();
        inventoryRepository.save(inventory);

    }
    @Test
    void getInventoryByLocation() {
        List<Inventory>inventoryLocation=inventoryRepository.getInventoryByLocation("Sohar");
        assertThat(inventoryLocation).isNotNull();
        assertThat(inventoryLocation.size()).isEqualTo(1);
        assertThat(inventoryLocation.get(0).getLocation()).isEqualTo("Sohar");
    }

    @Test
    void getInventoryByManager() {
        List<Inventory> inventoryManager=inventoryRepository.getInventoryByManager("Noura");
        assertThat(inventoryManager).isNotNull();
        assertThat(inventoryManager.size()).isEqualTo(1);
        assertThat(inventoryManager.get(0).getManager()).isEqualTo("Noura");

    }

   /* @Test
    void getInventoryBySupplier() {
        List<Inventory> inventorySupplier =inventoryRepository.getInventoryBySupplier("ABC");
        assertThat(inventorySupplier).isNotNull();
        assertThat(inventorySupplier.size()).isEqualTo(1);
        assertThat(inventorySupplier.get(0).getSupplier()).isEqualTo("ABC");

    }*/

    @Test
    void getInventoryByPhoneNumber() {
        List<Inventory> inventoryPhoneNumber =inventoryRepository.getInventoryByPhoneNumber("94086718");
        assertThat(inventoryPhoneNumber).isNotNull();
        assertThat(inventoryPhoneNumber.size()).isEqualTo(1);
        assertThat(inventoryPhoneNumber.get(0).getPhoneNumber()).isEqualTo("94086718");
    }

    @Test
    void getInventoryByOpeningHours() {
        List<Inventory> inventoryOpeningHours =inventoryRepository.getInventoryByOpeningHours("6 AM");
        assertThat(inventoryOpeningHours).isNotNull();
        assertThat(inventoryOpeningHours.size()).isEqualTo(1);
        assertThat(inventoryOpeningHours.get(0).getOpeningHours()).isEqualTo("6 AM");

    }

    @Test
    void getInventoryByClosingHours() {
        List<Inventory> inventoryClosingHours=inventoryRepository.getInventoryByClosingHours("10 PM");
        assertThat(inventoryClosingHours).isNotNull();
        assertThat(inventoryClosingHours.size()).isEqualTo(1);
        assertThat(inventoryClosingHours.get(0).getClosingHours()).isEqualTo("10 PM");

    }
}