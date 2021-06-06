package com.geektrust.challenge.mymoney.service;

import com.geektrust.challenge.mymoney.constants.Constants;
import com.geektrust.challenge.mymoney.service.impl.AllocateMoneyServiceImpl;
import com.geektrust.challenge.mymoney.service.impl.BalanceServiceImpl;
import com.geektrust.challenge.mymoney.service.impl.MonthlyChangeServiceImpl;
import com.geektrust.challenge.mymoney.service.impl.RebalanceServiceImpl;
import com.geektrust.challenge.mymoney.service.impl.SIPServiceImpl;

/*
    factory class which is used to get instance of implementation for each command type
 */
public class MyMoneyFactory {

    /*
       @param commandType : ALLOCATE, SIP, CHANGE, BALANCE, REBALANCE
       @Return MyMoneyService : Its an Interface which has implementations for each type of command,
               returns null if command type is incorrect
    */
    public static MyMoneyService getMyMoneyService(String commandType) {

        if(Constants.ALLOCATE.equals(commandType)) {
            return new AllocateMoneyServiceImpl();
        }
        else if(Constants.SIP.equals(commandType)) {
            return new SIPServiceImpl();
        }
        else if(Constants.CHANGE.equals(commandType)) {
            return new MonthlyChangeServiceImpl();
        }
        else if(Constants.BALANCE.equals(commandType)) {
            return new BalanceServiceImpl();
        }
        else if(Constants.REBALANCE.equals(commandType)){
            return new RebalanceServiceImpl();
        }
        else {
            return null;
        }
    }
}
