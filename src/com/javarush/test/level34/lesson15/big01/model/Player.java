package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

public class Player extends CollisionObject implements Movable {

    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        int startX = getX() - getWidth() / 2;
        int startY = getY() - getHeight() / 2;

        graphics.drawOval(startX, startY, getWidth(), getHeight());
        graphics.fillOval(startX, startY, getWidth(), getHeight());
    }

    @Override
    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }
}
