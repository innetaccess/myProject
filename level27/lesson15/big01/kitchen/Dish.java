package com.javarush.test.level27.lesson15.big01.kitchen;

import java.util.Arrays;

/**
 * Created by Николай on 26.06.2016.
 */
public enum Dish
{
    Fish, Steak, Soup, Juice, Water;
    public static String allDishesToString(){
        StringBuilder sb = new StringBuilder(Arrays.toString(values()));
        sb.delete(sb.length() - 1, sb.length());
        sb.delete(0, 1);
        return sb.toString();
    }
}
