package com.goblinslayer.character;

import java.util.Objects;

public class Monster extends Character {

    // Attributes
    private int hp;
    private MonsterType monsterType;

    // Business methods


    @Override
    public int attack(Character opponent) {
        int min = 0;
        int max = 5;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        // This is the *critical* modifier, adds additional damage on top of power
        return getMonsterType().getPower() + random_int;
    }

    @Override
    public int defend() {
        int min = 3;
        int max = 10;
        // generates a random defence between 3-10
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }

    // Accessor Methods
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public MonsterType getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(MonsterType monsterType) {
        this.monsterType = monsterType;
    }

    @Override
    public String toString() {
        return "Monster: " +
                "hp= " + getHp() +
                ", monsterType= " + getMonsterType() +
                ", Power= " + getMonsterType().getPower();
    }
}
