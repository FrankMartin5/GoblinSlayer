import java.util.Objects;

class Zombie extends Monster {

    // Attributes
    private String typeofMonster;
    private int powerLevel;
    private int hpLevel;
    private String attackType;

    //Constructor Method
    public Zombie(String typeofMonster, int powerLevel, int hpLevel, String attackType) {
        this.typeofMonster = typeofMonster;
        this.powerLevel = powerLevel;
        this.hpLevel = hpLevel;
        this.attackType = attackType;
    }

    // Business Methods
    @Override
    public void attack() {
        super.attack();
    }

    @Override
    public void defend() {
        super.defend();
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

    //Equals and Hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Zombie zombie = (Zombie) o;
        return powerLevel == zombie.powerLevel && hpLevel == zombie.hpLevel && typeofMonster.equals(zombie.typeofMonster) && attackType.equals(zombie.attackType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeofMonster, powerLevel, hpLevel, attackType);
    }

    // toString
    @Override
    public String toString() {
        return "Zombie{" +
                "typeofMonster='" + getTypeofMonster() + '\'' +
                ", powerLevel=" + getPowerLevel() +
                ", hpLevel=" + getHpLevel() +
                ", attackType='" + getAttackType() + '\'' +
                '}';
    }
}