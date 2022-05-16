package com.goblinslayer.monster;

import java.util.Objects;

class Goblin extends Monster {

    // Attributes
    private String typeofMonster;
    private int powerLevel;
    private int hpLevel;
    private String attackType;

    //Constructor Method
    public Goblin(String typeofMonster, int powerLevel, int hpLevel, String attackType) {
        super(typeofMonster, powerLevel, hpLevel, attackType);
    }

    // Business Methods
    @Override
    public int attack() {
        int min = 0;
        int max = 5;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        // This is the *critical* modifier, adds additional damage on top of power
        return powerLevel + random_int;
    }

    @Override
    public int defend() {
        int min = 3;
        int max = 10;
        // generates a random defence between 3-10
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }

    @Override
    public void run() {
        super.run();
    }

    // Accessor Methods

    @Override
    public String getTypeofMonster() {
        return typeofMonster;
    }

    @Override
    public void setTypeofMonster(String typeofMonster) {
        this.typeofMonster = typeofMonster;
    }

    @Override
    public int getPowerLevel() {
        return powerLevel;
    }

    @Override
    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    @Override
    public int getHpLevel() {
        return hpLevel;
    }

    @Override
    public void setHpLevel(int hpLevel) {
        this.hpLevel = hpLevel;
    }

    @Override
    public String getAttackType() {
        return attackType;
    }

    @Override
    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    // Equals and Hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Goblin goblin = (Goblin) o;
        return powerLevel == goblin.powerLevel && hpLevel == goblin.hpLevel && typeofMonster.equals(goblin.typeofMonster) && attackType.equals(goblin.attackType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeofMonster, powerLevel, hpLevel, attackType);
    }

    // toString
    @Override
    public String toString() {
        return "com.goblinslayer.monster.Goblin{" +
                ", powerLevel=" + getPowerLevel() +
                ", hpLevel=" + getHpLevel() +
                ", attackType='" + getAttackType() + '\'' +
                '}';
    }
}