package com.goblinslayer.player;

import java.util.Objects;

public class Player {
    private String name = "Hero"; // input
    private int hp = 50;
    private Weapon weapon;  // input
    private int power = 1;

    public Player(String name, int hp) {
        setName(name);
        setHp(hp);
    }

    public Player(String name, int hp, Weapon weapon, int power) {
        this(name, hp);
        setWeapon(weapon);
       setPower(power);
    }
// Business Methods

    public int attack(){
        int min = 0;
        int max = 5;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        // This is the *critical* modifier, adds additional damage on top of power
        return power + random_int;
    }

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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        switch (weapon){
            case AXE:
                this.power = 15;
                break;
            case SWORD:
                this.power = 13;
                break;
            case CLUB:
                this.power = 10;
                break;
            case STAFF:
                this.power = 12;
                break;
            case STICK:
                this.power = 1;
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return getHp() == player.getHp() && getPower() == player.getPower() && Objects.equals(getName(), player.getName()) && getWeapon() == player.getWeapon();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHp(), getWeapon(), getPower());
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", weapon=" + weapon +
                ", power=" + power +
                '}';
    }
}
