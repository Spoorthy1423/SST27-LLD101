package com.example.game;

public class GoldenAura extends CharacterDecorator {
    public GoldenAura(Character inner) {
        super(inner);
    }

    @Override
    public String getSprite() {
        return "golden-" + inner.getSprite();
    }

    @Override
    public int getSpeed() {
        return inner.getSpeed() + 1;
    }

    @Override
    public int getDamage() {
        return inner.getDamage() + 2;
    }

    @Override
    public void move() {
        System.out.println("[Aura✨] ");
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite());
    }

    @Override
    public void attack() {
        System.out.println("[Aura✨] ");
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }
}

