package com.machine.service;

import com.machine.entity.Ingredient;
import com.machine.exception.UnableToDispenseException;
import com.machine.repository.BeverageRepoImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BeverageService {

    BeverageRepoImpl beverageRepository;

    public BeverageService() {
        beverageRepository = new BeverageRepoImpl();
    }

    public void addBeverage(String beverageName, Map<Ingredient, Integer> ingredients) {
        beverageRepository.addBeverage(beverageName, ingredients);
    }

    public Map<Ingredient, Integer> getBeverage(String beverageName) {

        Map<Ingredient, Integer> ingredientMap = null;
        try {
            ingredientMap = beverageRepository.getBeverageIngredient(beverageName);
            System.out.println("Following ingredients are required to make");
            for (Ingredient ingredient : ingredientMap.keySet()) {
                System.out.println(ingredient.toString().toLowerCase() + " - " + ingredientMap.get(ingredient).toString().toLowerCase());
            }
        } catch (Exception ex) {
            new UnableToDispenseException("Unable to find the Beverage !!!" + beverageName);
        }

        return ingredientMap;
    }

    public List<String> getAllBeverages() {
        return beverageRepository.getAllBeverages();
    }


}
