package com.geektrust.challenge.mymoney.service.impl;

import com.geektrust.challenge.mymoney.model.CurrentPortfolio;
import com.geektrust.challenge.mymoney.model.Investment;
import com.geektrust.challenge.mymoney.model.InvestmentPercentage;
import com.geektrust.challenge.mymoney.model.InitialPortfolioAllocation;
import com.geektrust.challenge.mymoney.model.SIPAllocation;
import com.geektrust.challenge.mymoney.constants.Constants;
import com.geektrust.challenge.mymoney.service.MyMoneyService;
import com.geektrust.challenge.mymoney.utils.InvestmentUtil;

import java.util.Map;

public class MonthlyChangeServiceImpl implements MyMoneyService {
    CurrentPortfolio currentPortfolio =
            CurrentPortfolio.getCurrentPortfolio();
    InitialPortfolioAllocation initialPortfolioAllocation =
            InitialPortfolioAllocation.getPortFolioAllocation();
    SIPAllocation sipAllocation = SIPAllocation.getSipAllocation();


    /*
        @param data[] : CHANGE 4.00% 10.00% 2.00% JANUARY
        @param currentPortfolioMap : holds investment amount for each month
        @returns void
        updates portfolio amount for a given month
     */
    @Override
    public void processData(String[] data, Map<String, Investment> currentPortfolioMap) {

        int length = data.length;
        String month = data[length - 1];

        Investment currInvestment = currentPortfolio.getInvestment();
        Investment monthlyInvestment = new Investment(currInvestment);

        double equityChange = InvestmentUtil.getDoubleValueForPercentage(data[1]);
        double debtChange = InvestmentUtil.getDoubleValueForPercentage(data[2]);
        double goldChange = InvestmentUtil.getDoubleValueForPercentage(data[3]);

        if(!Constants.JANUARY.equals(month)) {
            addSIP(monthlyInvestment);
        }

        int equityAllocationAfterChange = InvestmentUtil.getAllocationAmountAfterChange(
                equityChange, monthlyInvestment.getEquityAllocation());
        int debtAllocationAfterChange = InvestmentUtil.getAllocationAmountAfterChange(
                debtChange, monthlyInvestment.getDebtAllocation());
        int goldAllocationAfterChange = InvestmentUtil.getAllocationAmountAfterChange(
                goldChange, monthlyInvestment.getGoldAllocation());

        InvestmentUtil.setEquityAllocation(monthlyInvestment, equityAllocationAfterChange);
        InvestmentUtil.setDebtAllocation(monthlyInvestment, debtAllocationAfterChange);
        InvestmentUtil.setGoldAllocation(monthlyInvestment, goldAllocationAfterChange);
        monthlyInvestment.setTotal(
                InvestmentUtil.sumOfThreeFunds(equityAllocationAfterChange, debtAllocationAfterChange, goldAllocationAfterChange));

        InvestmentUtil.setEquityAllocation(currInvestment, equityAllocationAfterChange);
        InvestmentUtil.setDebtAllocation(currInvestment, debtAllocationAfterChange);
        InvestmentUtil.setGoldAllocation(currInvestment, goldAllocationAfterChange);
        currInvestment.setTotal(
                InvestmentUtil.sumOfThreeFunds(equityAllocationAfterChange, debtAllocationAfterChange, goldAllocationAfterChange));

        if(Constants.JUNE.equals(month) || Constants.DECEMBER.equals(month)) {
            rebalance(monthlyInvestment);
            rebalance(currInvestment);
        }
        currentPortfolioMap.put(month , monthlyInvestment);
    }

    public void addSIP(Investment monthlyInvestment) {
        InvestmentUtil.setEquityAllocation(
                monthlyInvestment, sipAllocation.getEquitySIP() + monthlyInvestment.getEquityAllocation());
        InvestmentUtil.setDebtAllocation(
                monthlyInvestment, sipAllocation.getDebtSIP() + monthlyInvestment.getDebtAllocation());
        InvestmentUtil.setGoldAllocation(
                monthlyInvestment, sipAllocation.getGoldSIP() + monthlyInvestment.getGoldAllocation());
    }

    public void rebalance(Investment investment) {
        InvestmentPercentage investmentPercentage = initialPortfolioAllocation.getInvestmentPercentage();

        int equityRebalanced = InvestmentUtil.getActualAmountBasedOnPercentage(
                investment.getTotal() , investmentPercentage.getEquityPercentage());
        int debtRebalanced = InvestmentUtil.getActualAmountBasedOnPercentage(
                investment.getTotal() , investmentPercentage.getDebtPercentage());
        int goldRebalanced = InvestmentUtil.getActualAmountBasedOnPercentage(
                investment.getTotal() , investmentPercentage.getGoldPercentage());

        InvestmentUtil.setEquityAllocation(investment , equityRebalanced);
        InvestmentUtil.setDebtAllocation(investment , debtRebalanced);
        InvestmentUtil.setGoldAllocation(investment , goldRebalanced);
    }
}
