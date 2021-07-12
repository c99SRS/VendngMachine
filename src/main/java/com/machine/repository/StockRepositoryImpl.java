package com.machine.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StockRepositoryImpl implements StockRepository {


    Map<String, Integer> ingredientStock;

    public StockRepositoryImpl() {
        ingredientStock = new HashMap<>();
        ingredientStock.put("MILK", 6);
        ingredientStock.put("COFFEE", 6);
        ingredientStock.put("WATER", 6);
        ingredientStock.put("SUGAR", 6);
    }

    @Override
    public int getStock(String ingredientName) {

        if (ingredientStock.containsKey(ingredientName))
            return ingredientStock.get(ingredientName);
        return 0;
    }

    @Override
    public void addStock(String ingredientName, int amount) {

        int currStock = ingredientStock.get(ingredientName);
        ingredientStock.put(ingredientName, amount + currStock);
    }

    @Override
    public Map<String, Integer> getStock() {
        return ingredientStock;
    }

    @Override
    public boolean hasAvailableStock(String ingredientName, int amountRequired) {

        if (!ingredientStock.containsKey(ingredientName))
            System.out.println("No ingredients re present on this name: " + ingredientName);

        int currStock = ingredientStock.get(ingredientName);

        return currStock >= amountRequired;
    }

/*    public void consumeStock(String ingrdientName, int amount) throws Exception {

        if (checkIfIngredientIsPresent(ingrdientName) )
            throw new Exception();

        int currStock = ingredientStock.get(ingrdientName);
        int requiredStock = amount;

        if ( currStock < requiredStock )
            throw new Exception ("current stock less than requested amount ");

    }*/

    private boolean checkIfIngredientIsPresent(String ingrdientName) {
        if (!ingredientStock.containsKey(ingrdientName))
            return false;
        return true;
    }

    public void updateIngredientStock(Map<String, Integer> ingredientStringMap) {

        for (String ingredient : ingredientStringMap.keySet()) {
            int prevStock = ingredientStock.get(ingredient);
            int spendAmount = ingredientStringMap.get(ingredient);
            ingredientStock.put(ingredient, prevStock - spendAmount);
        }
        System.out.println("after update: " + ingredientStock);
    }


}
