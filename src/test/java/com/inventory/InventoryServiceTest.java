package com.inventory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryServiceTest {
    private InventoryService inventoryService;

    @BeforeEach
    void setUp() {
        inventoryService = new InventoryService();
        inventoryService.addProduct("PROD001", 50);
    }

    @Test
    void testStockIncrease() {
        int updated = inventoryService.updateStock("PROD001", 10);
        assertEquals(60, updated, "Stock should increase to 60");
    }

    @Test
    void testStockDecrease() {
        int updated = inventoryService.updateStock("PROD001", -20);
        assertEquals(30, updated, "Stock should decrease to 30");
    }

    @Test
    void testInsufficientStock() {
        assertThrows(IllegalArgumentException.class, () -> {
            inventoryService.updateStock("PROD001", -60);
        }, "Should throw exception for negative stock result");
    }

    @Test
    void testInvalidProduct() {
        assertThrows(IllegalArgumentException.class, () -> {
            inventoryService.updateStock("INVALID_ID", 10);
        });
    }
}