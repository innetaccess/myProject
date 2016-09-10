package com.javarush.test.level34.lesson15.big01.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Администратор on 30.08.2016.
 */
public class LevelLoader
{
    private Path levels;

    public LevelLoader(Path levels)
    {
        this.levels = levels;
    }

    public GameObjects getLevel(int level){
       Player player = new Player(80,50);
        Set<Home> homes = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Wall> walls = new HashSet<>();

        walls.add(new Wall(200, 200));
        walls.add(new Wall(180, 190));
        walls.add(new Wall(170, 220));
        homes.add(new Home(80, 80));
        boxes.add(new Box(30, 30));

        return new GameObjects(walls,boxes,homes, player);
    }

}
