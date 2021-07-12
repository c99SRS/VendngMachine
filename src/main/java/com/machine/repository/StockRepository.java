package com.machine.repository;

import java.util.Map;

public interface StockRepository {

    int getStock(String ingredientName);

    void addStock(String ingredientName, int amount);

    Map<String, Integer> getStock();

    boolean hasAvailableStock(String ingredientName, int amount);
}
