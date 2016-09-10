package com.javarush.test.level24.lesson14.big01;

import java.util.ArrayList;

/**
 * Created by Николай on 01.06.2016.
 */
public class Arcanoid
{
    private int width, height;
    private Stand stand;
    private Ball ball;
    private ArrayList<Brick> bricks;
    public static Arcanoid game;

    public ArrayList<Brick> getBricks() {return bricks;}
    public void setBricks(ArrayList<Brick> bricks) {this.bricks = bricks;}

    public Arcanoid(int width, int height)
    {
        this.width = width;
        this.height = height;
    }
    public Stand getStand() {return stand;}
    public Ball getBall() {return ball;}
    public void setStand(Stand stand) {this.stand = stand;}
    public void setBall(Ball ball) {this.ball = ball;}
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public void setWidth(int width) {this.width = width;}
    public void setHeight(int height) {this.height = height;}

    public void run(){}
    public void move(){}

    public static void main(String args[]){

    }
}
