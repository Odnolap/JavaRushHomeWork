package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

public class Home extends GameObject {
    public Home(int x, int y) {
        super(x, y, 2, 2);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        int startX = getX() - getWidth() / 2;
        int startY = getY() - getHeight() / 2;

        graphics.drawOval(startX, startY, getWidth(), getHeight());
    }
}
