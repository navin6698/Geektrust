package com.geektrust.challenge.mymoney.service.impl;

import com.geektrust.challenge.mymoney.model.Investment;
import com.geektrust.challenge.mymoney.constants.Constants;
import com.geektrust.challenge.mymoney.service.MyMoneyService;

import java.util.Map;

public class RebalanceServiceImpl implements MyMoneyService {

    /*
        @param data[] : REBALANCE
        @param currentPortfolioMap : holds investment amount for each month
        @returns void
        prints rebalance amount if portfolio is rebalanced
     */
    @Override
    public void processData(String[] data, Map<String, Investment> currentPortfolioMap) {
        Investment rebalancedAmount;

        if(currentPortfolioMap.containsKey(Constants.DECEMBER)) {
            rebalancedAmount = currentPortfolioMap.get(Constants.DECEMBER);
            System.out.println(rebalancedAmount.getEquityAllocation()+" "+rebalancedAmount.getDebtAllocation()+" "+rebalancedAmount.getGoldAllocation());
        }
        else if(currentPortfolioMap.containsKey(Constants.JUNE)){
            rebalancedAmount = currentPortfolioMap.get(Constants.JUNE);
            System.out.println(rebalancedAmount.getEquityAllocation()+" "+rebalancedAmount.getDebtAllocation()+" "+rebalancedAmount.getGoldAllocation());
        }
        else {
            System.out.println(Constants.CANT_REBALANCE);
        }
    }
}
