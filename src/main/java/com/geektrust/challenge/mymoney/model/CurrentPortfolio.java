package com.geektrust.challenge.mymoney.model;

/*
    This is class is used for current investment
*/
public class CurrentPortfolio {
    private Investment investment;
    private static CurrentPortfolio currentPortfolio;

    private CurrentPortfolio() {}

    public static CurrentPortfolio getCurrentPortfolio() {
        if(currentPortfolio == null) {
            currentPortfolio =  new CurrentPortfolio();
        }
        return currentPortfolio;
    }

    public Investment getInvestment() {
        return investment;
    }

    public void setInvestment(Investment investment) {
        this.investment = investment;
    }
}
