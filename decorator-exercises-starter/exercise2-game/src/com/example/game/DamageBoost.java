package com.example.game;

public class DamageBoost extends CharacterDecorator {
    private final int bonus;

    public DamageBoost(Character inner, int bonus) {
        super(inner);
        this.bonus = bonus;
    }

    @Override
    public int getDamage() {
        return inner.getDamage() + bonus;
    }

    @Override
    public void attack() {
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }
}

