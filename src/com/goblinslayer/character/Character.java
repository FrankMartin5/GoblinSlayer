package com.goblinslayer.character;

public abstract class Character {

    private int hp;
    private int defense;

    public Character() {
    }

    // Abstract Methods
    public abstract int attack(Character opponent);

    public abstract int defend();

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
