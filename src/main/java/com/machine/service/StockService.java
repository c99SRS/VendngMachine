package com.machine.service;

import com.machine.repository.StockRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StockService {

    private final int DEFAULT_STOCK=6;
    StockRepositoryImpl stockRepository;

    public StockService(){
        stockRepository = new StockRepositoryImpl();
    }

    public void addStock(String ingredientName, int amount){

        try {
            stockRepository.addStock(ingredientName,amount);
            System.out.println(amount + " amount of ingredient " + ingredientName +  " has been added to the stock");
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public int getStock(String ingredientName){
        return stockRepository.getStock(ingredientName);
    }

    public Map<String,Integer> getStock(){
        Map<String,Integer> stock = stockRepository.getStock();
        System.out.println("Here are the stocks for now!!!!");
        for (String ingredient: stock.keySet())
            System.out.println(ingredient + " - " + stock.get(ingredient));
        return stock;
    }

    public boolean hasAvailableStock(String ingredientName, int amount) {
        return stockRepository.hasAvailableStock(ingredientName, amount);
    }

    public Map<String, Integer> stockShortCalculate(Map<String, Integer> ingredientStringMap) {

        Map<String, Integer> shortageMap = new HashMap<>();

        for (String ingName: ingredientStringMap.keySet()){
            int currStock = getStock(ingName);   // 6
            int required = ingredientStringMap.get(ingName);    // 2

            if (currStock < required)
                shortageMap.put(ingName, required - currStock );
        }
        return shortageMap;
    }


    public void fillStock(Map<String,Integer> map) {

        System.out.println("before update fill stock: " + map);
        for (String ingredient : map.keySet() ){
                if (map.get(ingredient) <=0 ) {
                    map.put(ingredient,DEFAULT_STOCK);
                }
        }
        System.out.println("after updating stock: " + map);
    }


}
