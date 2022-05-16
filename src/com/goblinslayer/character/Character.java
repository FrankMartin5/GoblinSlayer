package com.goblinslayer.character;

public abstract class Character {

    public Character() {
    }
    
    public abstract int attack(Character opponent);

    public abstract int defend();
}
