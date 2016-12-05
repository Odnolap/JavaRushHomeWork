package com.javarush.test.level34.lesson15.big01.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import static com.javarush.test.level34.lesson15.big01.model.Model.FIELD_SELL_SIZE;

public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {

        Player player = new Player((int)(FIELD_SELL_SIZE * 1.5), (int)(FIELD_SELL_SIZE * 1.5));
        Box box = new Box((int)(FIELD_SELL_SIZE * 1.5), (int)(FIELD_SELL_SIZE * 2.5));
        Set<Box> boxes = new HashSet<>();
        boxes.add(box);
        Home home = new Home((int)(FIELD_SELL_SIZE * 1.5), (int)(FIELD_SELL_SIZE * 4.5));
        Set<Home> homes = new HashSet<>();
        homes.add(home);
        Set<Wall> walls = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            walls.add(new Wall((int)(FIELD_SELL_SIZE * 0.5), (int)(FIELD_SELL_SIZE * (0.5 + i))));
            walls.add(new Wall((int)(FIELD_SELL_SIZE * 2.5), (int)(FIELD_SELL_SIZE * (0.5 + i))));
        }
        walls.add(new Wall((int)(FIELD_SELL_SIZE * 1.5), (int)(FIELD_SELL_SIZE * 0.5)));
        walls.add(new Wall((int)(FIELD_SELL_SIZE * 1.5), (int)(FIELD_SELL_SIZE * 5.5)));

        return new GameObjects(walls, boxes, homes, player);
    }
}
