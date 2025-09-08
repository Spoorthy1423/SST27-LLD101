package com.example.game;

public class SpeedBoost extends CharacterDecorator {
    private final int bonus;

    public SpeedBoost(Character inner, int bonus) {
        super(inner);
        this.bonus = bonus;
    }

    @Override
    public int getSpeed() {
        return inner.getSpeed() + bonus;
    }

    @Override
    public void move() {
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite());
    }
}

