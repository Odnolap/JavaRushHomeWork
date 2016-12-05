package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

public class Box extends CollisionObject implements Movable {

    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        int startX = getX() - getWidth() / 2;
        int startY = getY() - getHeight() / 2;

        graphics.drawRect(startX, startY, getWidth(), getHeight());
        graphics.fillRect(startX, startY, getWidth(), getHeight());
    }

    @Override
    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }
}
