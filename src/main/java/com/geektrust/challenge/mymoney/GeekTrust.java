package com.geektrust.challenge.mymoney;

import com.geektrust.challenge.mymoney.model.Investment;
import com.geektrust.challenge.mymoney.service.MyMoneyFactory;
import com.geektrust.challenge.mymoney.service.MyMoneyService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GeekTrust {

    public static void main(String args[]) throws IOException {

        MyMoneyService moneyService;
        Map<String, Investment> currentPortfolioMap = new HashMap<>();
        String inputFile = args[0];
        File file = new File(inputFile);
        BufferedReader input = new BufferedReader(new FileReader(file));
        String inputCommand = "";

        while((inputCommand = input.readLine()) != null && inputCommand.length()!= 0) {
            String[] inputData = inputCommand.split(" ");
            moneyService = MyMoneyFactory.getMyMoneyService(inputData[0]);
            if(moneyService != null) {
                moneyService.processData(inputData,currentPortfolioMap);
            }
            else {
                System.out.println("Invalid Command type");
            }
        }
    }
}
