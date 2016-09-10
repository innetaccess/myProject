package com.javarush.test.level32.lesson08.home01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Администратор on 26.07.2016.
 */
public class CustomInvocationHandler implements InvocationHandler
{
    private SomeInterfaceWithMethods original;

    public CustomInvocationHandler(SomeInterfaceWithMethods someInterfaceWithMethods)
    {
        this.original = someInterfaceWithMethods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println(method.getName() +" in");
        Object result = method.invoke(original, args);
        System.out.println(method.getName() +" out");
        return result;
    }
}
