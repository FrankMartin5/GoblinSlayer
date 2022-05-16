package com.goblinslayer.character;

public enum MonsterType {
    GOBLIN(5),
    ZOMBIE(10),
    WEREWOLF(100);

    private int power;

    MonsterType(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
