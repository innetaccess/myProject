package com.javarush.test.level26.lesson10.home01;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Николай on 16.06.2016.
 */
public class Consumer implements Runnable
{
    protected BlockingQueue queue;
    public Consumer(BlockingQueue queue){
        this.queue = queue;
    }
    @Override
    public void run(){
        try
        {
            while (true){
                System.out.println(queue.take());
                Thread.sleep(300);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
