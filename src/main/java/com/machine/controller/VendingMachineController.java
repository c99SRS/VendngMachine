package com.machine.controller;

import com.machine.service.BeverageService;
import com.machine.service.BeverageVendingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VendingMachineController {

    BeverageService beverageService = new BeverageService();
    BeverageVendingServiceImpl beverageVendingService = new BeverageVendingServiceImpl();

    @GetMapping("/showAll")
    public List<String> showAllBeverages() {
        return beverageService.getAllBeverages();
    }

    @GetMapping("/getItem/{choice}")
    public String dispenseBeverage(@PathVariable String choice) {

        return beverageVendingService.prepare(choice);
    }

}
