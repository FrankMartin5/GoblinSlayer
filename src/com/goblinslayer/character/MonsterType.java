package com.goblinslayer.character;

public enum MonsterType {
    GOBLIN(10),
    ZOMBIE(5),
    WEREWOLF(50);

    private int power;

    MonsterType(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

}
