package com.goblinslayer.character;


public class Player extends Character{

    private String name;
    private int hp;
    private Weapon weapon;
    private int defense = 0;
    private int wallet = (int) Math.floor(Math.random() * (200 - 50) + 1) + 50;

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
        int newHp = opponent.getHp() - getWeapon().getPower();
        opponent.setHp(newHp);
        return newHp;
    }

    @Override
    public int defend(Monster opponent){
        int defend = 0;
        if (getDefense() >= opponent.getMonsterType().getPower()) {
            defend = opponent.getMonsterType().getPower() + getHp();
            setHp(defend);
            return defend;
        } else {
            defend = opponent.getMonsterType().getPower() - getDefense() + getHp();
            setHp(defend);
            return defend;
        }
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

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet){
        this.wallet = wallet;
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

