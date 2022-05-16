package com.goblinslayer.character;

public enum Weapon {
    SWORD(13),
    AXE(15),
    CLUB(10),
    STAFF(12),
    STICK(1);

    private int power;

    Weapon(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
