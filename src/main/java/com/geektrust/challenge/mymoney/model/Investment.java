package com.geektrust.challenge.mymoney.model;

/*
    POJO class for investment amount in each funds and total investment amount
 */
public class Investment {
    private int equityAllocation;
    private int debtAllocation;
    private int goldAllocation;
    private int total;

    public Investment() { }

    public Investment(Investment investment) {
        equityAllocation = investment.getEquityAllocation();
        debtAllocation = investment.getDebtAllocation();
        goldAllocation = investment.getGoldAllocation();
        total = investment.getTotal();

    }
    public int getEquityAllocation() {
        return equityAllocation;
    }

    public void setEquityAllocation(int equityAllocation) {
        this.equityAllocation = equityAllocation;
    }

    public int getDebtAllocation() {
        return debtAllocation;
    }

    public void setDebtAllocation(int debtAllocation) {
        this.debtAllocation = debtAllocation;
    }

    public int getGoldAllocation() {
        return goldAllocation;
    }

    public void setGoldAllocation(int goldAllocation) {
        this.goldAllocation = goldAllocation;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
