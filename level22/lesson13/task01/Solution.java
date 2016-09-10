package com.javarush.test.level22.lesson13.task01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static void main(String args[]){
        String query = "level22.lesson13.task01";
        String delmiter = ".";
        System.out.print(getTokens(query,delmiter));
    }
    public static String [] getTokens(String query, String delimiter) {
        List<String> word = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            word.add(token);
        }
        String[] s = new String[word.size()];
        return word.toArray(s);
    }
}
