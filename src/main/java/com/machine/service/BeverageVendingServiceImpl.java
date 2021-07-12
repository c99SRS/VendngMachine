package com.machine.service;

import com.machine.entity.Admin;
import com.machine.entity.Ingredient;
import com.machine.exception.BeveragePrepareFailedException;
import com.machine.repository.StockRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BeverageVendingServiceImpl implements BeverageVendingService {

    BeverageService beverageService;
    StockService stockService;
    StockRepositoryImpl stockRepository;
    NotificationService notificationService;

    public BeverageVendingServiceImpl() {
        beverageService = new BeverageService();
        stockService = new StockService();
        stockRepository = new StockRepositoryImpl();
        notificationService = new NotificationServiceImpl();
    }

    @Override
    public String prepare(String beverageName) {

        try {
            Map<Ingredient, Integer> ingredientMap = beverageService.getBeverage(beverageName);
            Map<String, Integer> ingredientStringMap = new HashMap<>();

            if (!checkIfAvailable(stockRepository.getStock())) {

                String notification = notificationService.notifyUser(new Admin()) + " \n Will be filled soon. Please come later.......";
                stockService.fillStock(stockRepository.getStock());
                return notification;
            }
            for (Ingredient ingredient : ingredientMap.keySet()) {

                ingredientStringMap.put(ingredient.toString(), ingredientMap.get(ingredient));
            }

            Map<String, Integer> shortageMap = stockService.stockShortCalculate(ingredientStringMap);
            System.out.println("shortage map: " + shortageMap);

            if (shortageMap.size() == 0) {
                // update stock;
                stockRepository.updateIngredientStock(ingredientStringMap);
                return "Your order " + beverageName + " is Prepared !!!";
            } else {
                for (String ingredient : shortageMap.keySet())
                    System.out.println(ingredient + " is short by " + shortageMap.get(ingredient));
            }
        } catch (Exception e) {
            new BeveragePrepareFailedException("Exception occured while preparing your order!!!");
        }

        return "Have a great Day !!!";
    }

    private boolean checkIfAvailable(Map<String, Integer> ingredientMap) {

        for (String ingredient : ingredientMap.keySet()) {
            if (ingredientMap.get(ingredient) <= 0)
                return false;
        }
        return true;
    }


}
