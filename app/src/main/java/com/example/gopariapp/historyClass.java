package com.example.gopariapp;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class historyClass {
    private String activity;
    private int currencyUsd;
    private int currencyRp;
    private String time;
    public historyClass()
    {
       //empty constructor needed
    }
    public historyClass(String activity, int currencyRp, int currencyUsd, String time)
    {
        this.activity=activity;
        this.currencyRp=currencyRp;
        this.currencyUsd=currencyUsd;
        this.time=time;
    }

    public String getActivity() {
        return activity;
    }

    public int getCurrencyUsd() {
        return currencyUsd;
    }

    public int getCurrencyRp() {
        return currencyRp;
    }

    public String getTime() {
        return time;
    }
}



