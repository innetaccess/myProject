package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;

/**
 * Created by Николай on 26.06.2016.
 */
public class Tablet
{
    final static Logger logger = Logger.getLogger(Tablet.class.getName());

    private final int number;

    public Tablet(int number)
    {
        this.number = number;
    }
    public void createOrder(){
        Order order = null;
        try
        {
            order = new Order(this);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");

        }
    }
    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }
}
