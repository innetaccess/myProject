package com.javarush.test.level26.lesson08.task01;

import java.util.concurrent.atomic.AtomicInteger;

/* Вежливость - это искусственно созданное хорошее настроение.
В классе Solution создайте public static класс IntegerHolder.
IntegerHolder должен быть для типа int, быть нитебезопасным и изменяемым.
В этом классе должны быть два public метода get и set
*/
public class Solution {
    public static class IntegerHolder{
        public final AtomicInteger h1 = new AtomicInteger();

        public synchronized int get()
        {
            return h1.get();
        }

        public synchronized void set(int i)
        {
            h1.set(i);
        }
    }
    public static void main(String[] args) {

    }
}
