package com.goblinslayer.shop;

import java.util.Objects;

public class Armor {

    // Fields
    private Integer id;
    private String itemName;
    private Double price;
    private Integer defRating;

    // Constructors
    public Armor(Integer id){
        this.id = id;
    }

    public Armor(Integer id, String itemName, Double price, Integer defRating) {
        this(id);
        this.itemName = itemName;
        this.price = price;
        this.defRating = defRating;
    }

    // Accessor Methods
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDefRating() {
        return defRating;
    }

    public void setDefRating(Integer defRating) {
        this.defRating = defRating;
    }

    // Equals and Hash
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Armor armor = (Armor) o;
        return Objects.equals(id, armor.id) && Objects.equals(itemName, armor.itemName) && Objects.equals(price, armor.price) && Objects.equals(defRating, armor.defRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getItemName(), getPrice(), getDefRating());
    }

    @Override
    public String toString() {
        return "Armor{" +
                "id=" + getId() +
                ", itemName='" + getItemName() + '\'' +
                ", price=" + getPrice() +
                ", defRating=" + getDefRating() +
                '}';
    }
}