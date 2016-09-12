package com.javarush.test.level26.lesson15.big01;

import java.util.Map;

/**
 * Created by Администратор on 12.09.2016.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }
}
