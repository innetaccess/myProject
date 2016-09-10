package com.javarush.test.level31.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Администратор on 21.07.2016.
 */
public class ConsoleHelper
{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }
    public static String readString() throws IOException{
        String message = br.readLine();
        return message;
    }
    public static int readInt()throws IOException{
        int number = Integer.parseInt(readString());
        return number;
    }
}

