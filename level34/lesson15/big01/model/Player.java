package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Администратор on 29.08.2016.
 */
public class Player extends CollisionObject implements Movable
{
    public Player(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void move(int x, int y)
    {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.YELLOW);

        int leftUpperCornerX = getX() - getHeight() / 2;
        int leftUpperCornerY = getY() - getWidth() / 2;
        graphics.drawRect(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
        graphics.fillRect(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());


    }
}
