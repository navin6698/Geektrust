package com.geektrust.challenge.mymoney.model;

/*
    POJO class for SIP amount for each fund
 */
public class SIPAllocation {

    private int equitySIP;
    private int debtSIP;
    private int goldSIP;

    private static SIPAllocation sipAllocation;

    private SIPAllocation() { }

    public static SIPAllocation getSipAllocation()
    {
        if(sipAllocation == null) {
            sipAllocation = new SIPAllocation();
        }
        return sipAllocation;
    }

    public int getEquitySIP() {
        return equitySIP;
    }

    public void setEquitySIP(int equitySIP) {
        this.equitySIP = equitySIP;
    }

    public int getDebtSIP() {
        return debtSIP;
    }

    public void setDebtSIP(int debtSIP) {
        this.debtSIP = debtSIP;
    }

    public int getGoldSIP() {
        return goldSIP;
    }

    public void setGoldSIP(int goldSIP) {
        this.goldSIP = goldSIP;
    }
}
