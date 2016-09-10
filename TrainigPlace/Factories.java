package com.javarush.test.TrainigPlace;

/**
 * Created by Николай on 07.05.2016.
 */
interface Service{
    void method1();
    void method2();
}
interface ServiceFabric{
    Service getService();
}
class Implementation1 implements Service{
    Implementation1(){}

    @Override
    public void method1()
    {
        System.out.println("Implementation1 method1");
    }

    @Override
    public void method2()
    {
        System.out.println("Implementation1 method2");
    }
}
class ImplementationFabric implements ServiceFabric{
    public Service getService(){
        return new Implementation1();
    }
}

class Implementation2 implements Service{
    Implementation2(){}

    @Override
    public void method1()
    {
        System.out.println("Implementation2 method1");
    }

    @Override
    public void method2()
    {
        System.out.println("Implementation2 method2");
    }
}
class ImplementationFabric2 implements ServiceFabric{
    @Override
    public Service getService()
    {
        return new Implementation2();
    }
}
public class Factories
{
    public static void serviceConsumer(ServiceFabric fact){
        Service s = fact.getService();
        s.method1();
        s.method2();
    }
    public static void main(String args[]){
        serviceConsumer(new ImplementationFabric());
        serviceConsumer(new ImplementationFabric2());
    }
}

