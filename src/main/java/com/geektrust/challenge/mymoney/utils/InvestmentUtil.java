package com.geektrust.challenge.mymoney.utils;

import com.geektrust.challenge.mymoney.constants.Constants;
import com.geektrust.challenge.mymoney.model.Investment;

public class InvestmentUtil {

    public static void setEquityAllocation(Investment investment , int amount){
        investment.setEquityAllocation(amount);
    }

    public static void setDebtAllocation(Investment investment , int amount){
        investment.setDebtAllocation(amount);
    }

    public static void setGoldAllocation(Investment investment , int amount){
        investment.setGoldAllocation(amount);
    }

    public static int getIntValue(String value) {
        return Integer.parseInt(value);
    }

    public static int getActualAmountBasedOnPercentage(int total , int percentage) {
        return ((total * percentage) / 100);
    }

    public static int getPercentageForInvestment(int investmentAmount, int total) {
        return ((investmentAmount * 100) / total);
    }

    public static int sumOfThreeFunds(int equity, int debt, int gold) {
        return (equity + debt + gold);
    }

    public static int getAllocationAmountAfterChange(double changeAmount , int availableAmount) {
        return (int)(((changeAmount / 100) * availableAmount) + availableAmount);
    }

    /*
        Remove Percentage Symbol and returns double values
     */
    public static double getDoubleValueForPercentage(String percentage) {
        if(percentage != null && percentage.contains(Constants.PERCENTAGE)) {
            int length = percentage.length();
            Double value = Double.parseDouble(percentage.substring(0,length-1));
            return value;
        }
        return 0.00;
    }
}
