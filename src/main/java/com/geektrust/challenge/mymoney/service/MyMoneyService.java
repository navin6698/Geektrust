package com.geektrust.challenge.mymoney.service;

import com.geektrust.challenge.mymoney.model.Investment;

import java.util.Map;

public interface MyMoneyService {

    void processData(String[] data, Map<String, Investment> currentPortfolioMap);

}
