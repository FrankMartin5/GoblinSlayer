package com.goblinslayer.character;

public enum MonsterType {
    GOBLIN(15),
    ZOMBIE(5),
    WEREWOLF(45);

    private int power;

    MonsterType(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

}
