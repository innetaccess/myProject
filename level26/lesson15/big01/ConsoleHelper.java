package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Николай on 20.06.2016.
 */
public class ConsoleHelper
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        String message = "";
        try
        {
             message = br.readLine();
        }
        catch (IOException ignore)
        {
        }
        return message;
    }
}
