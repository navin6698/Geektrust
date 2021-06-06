package com.geektrust.challenge.mymoney.service.impl;

import com.geektrust.challenge.mymoney.model.Investment;
import com.geektrust.challenge.mymoney.model.InitialPortfolioAllocation;
import com.geektrust.challenge.mymoney.model.SIPAllocation;
import com.geektrust.challenge.mymoney.service.MyMoneyService;

import java.util.Map;

public class SIPServiceImpl implements MyMoneyService {
    InitialPortfolioAllocation initialPortfolioAllocation =
            InitialPortfolioAllocation.getPortFolioAllocation();
    SIPAllocation sipAllocation = SIPAllocation.getSipAllocation();

    /*
    @Param data: SIP 2000 1000 500
    @Param currentPortfolioMap :  holds investment amount of a month
    @returns void
     */
    @Override
    public void processData(String[] data, Map<String, Investment> currentPortfolioMap) {

        sipAllocation.setEquitySIP(Integer.parseInt(data[1]));
        sipAllocation.setDebtSIP(Integer.parseInt(data[2]));
        sipAllocation.setGoldSIP(Integer.parseInt(data[3]));
        initialPortfolioAllocation.setSipAllocation(sipAllocation);

    }
}
