package com.machine.repository;

import com.machine.entity.Ingredient;

import java.util.Map;

public interface BeverageRepository {

    Map<Ingredient, Integer> getBeverageIngredient(String beverageName);
    void addBeverage(String beverageName, Map<Ingredient, Integer> ingredientMap );

}
