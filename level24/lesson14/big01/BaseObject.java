package com.javarush.test.level24.lesson14.big01;

/**
 * Created by Николай on 01.06.2016.
 */
public abstract class BaseObject
{
    private double x, y, radius;
    BaseObject(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public double getX(){return x;}
    public double getY(){return y;}
    public double getRadius(){return radius;}

    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.y = y;}
    public void setRadius(double radius){this.radius = radius;}

    public abstract void run();
    public abstract void move();
    public boolean isIntersec(BaseObject o){
        double dx = x - o.x;
        double dy = y - o.y;
        double destination = Math.sqrt(dx * dx + dy * dy);
        double destination2 = Math.max(radius, o.radius);
        return destination <= destination2;
    }
}
