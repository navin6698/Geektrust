package com.geektrust.challenge.mymoney.model;

/*
    This is class is used for initial investment amount,
    Percentage for each type of funds,
    SIP amount for each month
*/
public class InitialPortfolioAllocation {

    private static InitialPortfolioAllocation initialPortfolioAllocation;

    private Investment investment;
    private InvestmentPercentage investmentPercentage;
    private SIPAllocation sipAllocation;

    private InitialPortfolioAllocation() {}

    public static InitialPortfolioAllocation getPortFolioAllocation() {
        if(initialPortfolioAllocation == null) {
            initialPortfolioAllocation = new InitialPortfolioAllocation();
        }
        return initialPortfolioAllocation;
    }

    public Investment getInvestment() {
        return investment;
    }

    public void setInvestment(Investment investment) {
        this.investment = investment;
    }

    public InvestmentPercentage getInvestmentPercentage() {
        return investmentPercentage;
    }

    public void setInvestmentPercentage(InvestmentPercentage investmentPercentage) {
        this.investmentPercentage = investmentPercentage;
    }

    public SIPAllocation getSipAllocation() {
        return sipAllocation;
    }

    public void setSipAllocation(SIPAllocation sipAllocation) {
        this.sipAllocation = sipAllocation;
    }
}
