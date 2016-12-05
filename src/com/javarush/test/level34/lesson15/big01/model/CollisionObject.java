package com.javarush.test.level34.lesson15.big01.model;

import static com.javarush.test.level34.lesson15.big01.model.Model.FIELD_SELL_SIZE;

public abstract class CollisionObject extends GameObject{

    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        int newX = this.getX();
        int newY = this.getY();
        switch (direction) {
            case DOWN: newY += FIELD_SELL_SIZE; break;
            case LEFT: newX -=  FIELD_SELL_SIZE; break;
            case UP: newY -=  FIELD_SELL_SIZE; break;
            case RIGHT: newX +=  FIELD_SELL_SIZE;
        }

        return gameObject.getX() == newX
                && gameObject.getY() == newY;
    }
}
