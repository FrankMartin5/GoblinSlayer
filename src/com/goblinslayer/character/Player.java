package com.goblinslayer.character;


public class Player extends Character{

    private String name;
    private int hp;
    private Weapon weapon;
    private Integer defense;

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
        int min = 0;
        int max = 5;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        // This is the *critical* modifier, adds additional damage on top of power
        return getWeapon().getPower() + random_int;
    }

    @Override
    public int defend(){
        int min = 3;
        int max = 10;
        // generates a random defence between 3-10
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
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

    @Override
    public String toString() {
        return "Player: " +
                "name= " + getName() +
                ", hp= " + getHp() +
                ", weapon= " + getWeapon() +
                ", Power= " + getWeapon().getPower();
    }
}
