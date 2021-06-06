package com.geektrust.challenge.mymoney.model;

/*
    POJO class for investment percentage made in each funds
 */
public class InvestmentPercentage {

    private int equityPercentage;
    private int debtPercentage;
    private int goldPercentage;

    public int getEquityPercentage() {
        return equityPercentage;
    }

    public void setEquityPercentage(int equityPercentage) {
        this.equityPercentage = equityPercentage;
    }

    public int getDebtPercentage() {
        return debtPercentage;
    }

    public void setDebtPercentage(int debtPercentage) {
        this.debtPercentage = debtPercentage;
    }

    public int getGoldPercentage() {
        return goldPercentage;
    }

    public void setGoldPercentage(int goldPercentage) {
        this.goldPercentage = goldPercentage;
    }
}
