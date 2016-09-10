package com.javarush.test.TrainigPlace;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Николай on 23.05.2016.
 */
public class Lesson2
{ static int x;
    public static void main(String args[]){
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {

            }
        }).start();
        Class s = Lesson2.class;
        System.out.print(Arrays.toString(s.getDeclaredFields()));
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        int i, x;
        while (sc.hasNextInt()){
            i = sc.nextInt();
            System.out.print(i + 2);
        }



    }
}
