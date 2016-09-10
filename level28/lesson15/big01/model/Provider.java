package com.javarush.test.level28.lesson15.big01.model;

/**
 * Created by Николай on 06.07.2016.
 */
public class Provider
{
    private Strategy strategy;

    public void setStrategy(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public Provider(Strategy strategy)
    {

        this.strategy = strategy;
    }
}
