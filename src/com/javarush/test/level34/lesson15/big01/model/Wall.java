package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

public class Wall extends CollisionObject {

    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        int startX = getX() - getWidth() / 2;
        int startY = getY() - getHeight() / 2;

        graphics.drawRect(startX, startY, getWidth(), getHeight());
        graphics.fillRect(startX, startY, getWidth(), getHeight());
    }
}
