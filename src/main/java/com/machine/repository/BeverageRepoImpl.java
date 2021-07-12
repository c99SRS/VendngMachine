package com.machine.repository;

import com.machine.entity.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BeverageRepoImpl implements BeverageRepository {

    private String BLACKCOFEE = "BLACKCOFEE";
    private String MILKCOFFEE = "MILKCOFFEE";
    private String SUGARLESSBLACKCOFFEEE = "SUGARLESSBLACKCOFFEEE";
    private String SUGARLESSMILKCOFFEE = "SUGARLESSMILKCOFFEE";

    Map<String, Map<Ingredient, Integer>> beverageMap = new HashMap<>();

    List<String> beverageList;

    public BeverageRepoImpl() {

        beverageList = new ArrayList<>();

        HashMap<Ingredient, Integer> blackCofeeMap = new HashMap<>();
        blackCofeeMap.put(Ingredient.COFFEE, 1);
        blackCofeeMap.put(Ingredient.SUGAR, 1);
        blackCofeeMap.put(Ingredient.WATER, 3);
        beverageMap.put(BLACKCOFEE, blackCofeeMap);
        beverageList.add(BLACKCOFEE);

        HashMap<Ingredient, Integer> milkCoffeeMap = new HashMap<>();
        milkCoffeeMap.put(Ingredient.COFFEE, 1);
        milkCoffeeMap.put(Ingredient.SUGAR, 1);
        milkCoffeeMap.put(Ingredient.WATER, 1);
        milkCoffeeMap.put(Ingredient.MILK, 2);
        beverageMap.put(MILKCOFFEE, milkCoffeeMap);
        beverageList.add(MILKCOFFEE);

        // sugarless blackcoffee
        HashMap<Ingredient, Integer> sugarLessBlackCofeeMap = new HashMap<>();
        sugarLessBlackCofeeMap.put(Ingredient.COFFEE, 1);
        sugarLessBlackCofeeMap.put(Ingredient.WATER, 3);
        beverageMap.put("BLACKCOFEE", sugarLessBlackCofeeMap);
        beverageMap.put(SUGARLESSBLACKCOFFEEE, sugarLessBlackCofeeMap);
        beverageList.add(SUGARLESSBLACKCOFFEEE);
        // sugarless milk coffee
        HashMap<Ingredient, Integer> sugarLessMilkCoffeeMap = new HashMap<>();
        sugarLessMilkCoffeeMap.put(Ingredient.COFFEE, 1);
        sugarLessMilkCoffeeMap.put(Ingredient.WATER, 1);
        sugarLessMilkCoffeeMap.put(Ingredient.MILK, 2);
        beverageMap.put("", sugarLessMilkCoffeeMap);
        beverageList.add(SUGARLESSMILKCOFFEE);
    }

    @Override
    public Map<Ingredient, Integer> getBeverageIngredient(String beverageName) {

        if (beverageMap.containsKey(beverageName))
            return beverageMap.get(beverageName);
        return null;
    }

    @Override
    public void addBeverage(String beverageName, Map<Ingredient, Integer> ingredientMap) {

        if (beverageMap.containsKey(beverageName))
            System.out.println("Beverage is already present ");
        else
            beverageMap.put(beverageName, ingredientMap);
    }

    public List<String> getAllBeverages() {
        return beverageList;
    }


}
