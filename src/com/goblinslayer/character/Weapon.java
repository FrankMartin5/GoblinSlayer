package com.goblinslayer.character;

public enum Weapon {
    SWORD(20),
    AXE(25),
    CLUB(15),
    STAFF(20),
    STICK(1);

    private int power;

    Weapon(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
