package com.goblinslayer.character;

import java.util.Objects;

public class Monster extends Character {

    // Attributes
    private int hp;
    private MonsterType monsterType;
    private int defense = 5;

    // Constructors
    public Monster() {
    }

    public Monster(int hp, MonsterType monsterType) {
        this.hp = hp;
        this.monsterType = monsterType;
    }

    // Business methods
    @Override
    public int attack(Character opponent) {
        int newHp = opponent.getHp() - getMonsterType().getPower();
        opponent.setHp(newHp);
        return newHp;
    }

    @Override
    public int defend(Monster opponent) {
        return defense;
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
