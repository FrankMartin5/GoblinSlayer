package com.goblinslayer.monster;

import java.util.Objects;

abstract class Monster {

    // Attributes
    private String typeofMonster;
    private int powerLevel;
    private int hpLevel;
    private String attackType;

    public Monster(String typeofMonster, int powerLevel, int hpLevel, String attackType) {
        this.typeofMonster = typeofMonster;
        this.powerLevel = powerLevel;
        this.hpLevel = hpLevel;
        this.attackType = attackType;
    }

    // Business methods
    public int attack() {
        return 0;
    }

    public int defend() {
        return 0;
    }

    public void run() {

    }

    // Accessor Methods
    public String getTypeofMonster() {
        return typeofMonster;
    }

    public void setTypeofMonster(String typeofMonster) {
        this.typeofMonster = typeofMonster;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public int getHpLevel() {
        return hpLevel;
    }

    public void setHpLevel(int hpLevel) {
        this.hpLevel = hpLevel;
    }

    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    // Equals and Hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return powerLevel == monster.powerLevel && hpLevel == monster.hpLevel && typeofMonster.equals(monster.typeofMonster) && attackType.equals(monster.attackType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeofMonster, powerLevel, hpLevel, attackType);
    }

    // toString

    @Override
    public String toString() {
        return "com.goblinslayer.monster.Monster{" +
                "typeofMonster='" + typeofMonster + '\'' +
                ", powerLevel=" + powerLevel +
                ", hpLevel=" + hpLevel +
                ", attackType='" + attackType + '\'' +
                '}';
    }
}