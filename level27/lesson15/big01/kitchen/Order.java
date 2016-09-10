package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Николай on 26.06.2016.
 */
public class Order
{
    private List<Dish> dishes;
    private Tablet tablet;
    public Order (Tablet tablet) throws IOException
    {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
        this.tablet = tablet;
    }

    @Override
    public String toString()
    {
        if (dishes.isEmpty())
            return "";
        else
            return "Your order: " + dishes.toString() + " of " + tablet;
    }
}
