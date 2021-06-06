package com.geektrust.challenge.mymoney.service.impl;

import com.geektrust.challenge.mymoney.model.Investment;
import com.geektrust.challenge.mymoney.service.MyMoneyService;

import java.util.Map;

public class BalanceServiceImpl implements MyMoneyService  {

    /*
        @param data[] : BALANCE MARCH
        @param currentPortfolioMap : holds investment amount for each month
        @returns void
        prints balance amount for a given month
     */
    @Override
    public void processData(String[] data, Map<String, Investment> currentPortfolioMap) {

        String month = data[1];

        if(currentPortfolioMap.get(month) != null) {
            int equity = currentPortfolioMap.get(month).getEquityAllocation();
            int debt = currentPortfolioMap.get(month).getDebtAllocation();
            int gold = currentPortfolioMap.get(month).getGoldAllocation();
            System.out.printf("%d, %d, %d",equity,debt,gold);
            System.out.println();
        }
        else {
            System.out.println("Balance not available for a given month");
        }
    }
}
