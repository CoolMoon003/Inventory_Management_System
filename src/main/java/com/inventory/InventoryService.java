package com.inventory;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private Map<String, Integer> stockMap = new HashMap<>();

    public void addProduct(String productId, int initialStock) {
        stockMap.put(productId, initialStock);
    }

    public int updateStock(String productId, int quantityChange) {
        if (!stockMap.containsKey(productId)) {
            throw new IllegalArgumentException("Product ID not found");
        }
        
        int currentStock = stockMap.get(productId);
        int newStock = currentStock + quantityChange;

        if (newStock < 0) {
            throw new IllegalArgumentException("Insufficient stock level");
        }

        stockMap.put(productId, newStock);
        return newStock;
    }

    public int getStock(String productId) {
        return stockMap.getOrDefault(productId, 0);
    }
}