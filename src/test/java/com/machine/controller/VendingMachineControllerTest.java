package com.machine.controller;

import com.machine.service.BeverageService;
import com.machine.service.BeverageVendingServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.*;

public class VendingMachineControllerTest {

    @InjectMocks
    private VendingMachineController vendingMachineController = new VendingMachineController();

    @Test
    void showAllBeverages() {
        List<String> anslist = vendingMachineController.showAllBeverages();
        Assert.assertEquals(4,anslist.size());
    }

    @Test
    void dispenseBeverage() {

        String input= "BLACKCOFEE";
        String ans = vendingMachineController.dispenseBeverage(input);

        Assert.assertNotNull(ans);
    }

    @Test
    void dispenseBeverageWithZeroInput() {

        String input= "";
        String ans = vendingMachineController.dispenseBeverage(input);

        Assert.assertNotNull(ans);
    }



}