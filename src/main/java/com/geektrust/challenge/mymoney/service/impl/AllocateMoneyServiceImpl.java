package com.geektrust.challenge.mymoney.service.impl;

import com.geektrust.challenge.mymoney.model.CurrentPortfolio;
import com.geektrust.challenge.mymoney.model.Investment;
import com.geektrust.challenge.mymoney.model.InvestmentPercentage;
import com.geektrust.challenge.mymoney.model.InitialPortfolioAllocation;
import com.geektrust.challenge.mymoney.constants.Constants;
import com.geektrust.challenge.mymoney.service.MyMoneyService;
import com.geektrust.challenge.mymoney.utils.InvestmentUtil;

import java.util.Map;

public class AllocateMoneyServiceImpl implements MyMoneyService {

    InitialPortfolioAllocation initialPortfolioAllocation =
            InitialPortfolioAllocation.getPortFolioAllocation();
    CurrentPortfolio currentPortfolio = CurrentPortfolio.getCurrentPortfolio();
    Investment investment = new Investment();
    InvestmentPercentage investmentPercentage = new InvestmentPercentage();

    /*
        @param data[] : ALLOCATE 6000 3000 1000
        @param currentPortfolioMap : holds investment amount for each month
        @returns void
     */
    @Override
    public void processData(String[] data, Map<String, Investment> currentPortfolioMap) {

        InvestmentUtil.setEquityAllocation(investment , InvestmentUtil.getIntValue(data[1]));
        InvestmentUtil.setDebtAllocation(investment , InvestmentUtil.getIntValue(data[2]));
        InvestmentUtil.setGoldAllocation(investment , InvestmentUtil.getIntValue(data[3]));

        int total = InvestmentUtil.sumOfThreeFunds(investment.getEquityAllocation(),
                investment.getDebtAllocation(), investment.getGoldAllocation());
        investment.setTotal(total);

        investmentPercentage.setEquityPercentage(
                InvestmentUtil.getPercentageForInvestment(investment.getEquityAllocation() , total));
        investmentPercentage.setDebtPercentage(
                InvestmentUtil.getPercentageForInvestment(investment.getDebtAllocation() , total));
        investmentPercentage.setGoldPercentage(
                InvestmentUtil.getPercentageForInvestment(investment.getGoldAllocation() , total));

        initialPortfolioAllocation.setInvestment(investment);
        initialPortfolioAllocation.setInvestmentPercentage(investmentPercentage);

        currentPortfolio.setInvestment(investment);
        currentPortfolioMap.put(Constants.JANUARY , investment);
    }
}
