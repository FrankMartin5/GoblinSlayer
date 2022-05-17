package com.goblinslayer.character;


public class Player extends Character{

    private String name;
    private int hp;
    private Weapon weapon;
    private int defense = 0;

    public Player() {
    }

    public Player(String name, int hp, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.weapon = weapon;
    }


    // Business Methods
    @Override
    public int attack(Character opponent) {
        return getWeapon().getPower();
    }

    @Override
    public int defend(){
        return defense;
    }

    // Accessor Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return "Player: " +
                "name= " + getName() +
                ", hp= " + getHp() +
                ", weapon= " + getWeapon() +
                ", Power= " + getWeapon().getPower() +
                ", Defense= " + getDefense();
    }
}

