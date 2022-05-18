package com.goblinslayer.shop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArmorShop implements Shop {


    private List<Armor> armorInventory = new ArrayList<>(List.of(
            new Armor(1, "Cloth Armor", 20.00, 5),
            new Armor(2, "Leather Armor", 50.00, 10),
            new Armor(3, "Steel Armor", 100.00, 15),
            new Armor(4, "Gold Plated Armor", 200.00, 20)
    ));


    @Override
    public Collection<Armor> listAllArmor() {
        Collection<Armor> result = new ArrayList<>();
        for (Armor item: armorInventory){
            result.add(item);
        }
        return result;
    }

    @Override
    public Armor findById(Integer id) {
        Armor result = null;
        for (Armor item : armorInventory) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    @Override
    public Collection<Armor> findByArmorName(String name) {
        Collection<Armor> result = new ArrayList<>();
        for (Armor item : armorInventory) {
            if (item.getItemName().toLowerCase().contains(name.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Armor item: armorInventory) {
            builder.append(item.getItemName()).append("   ").append("$ ").append(item.getPrice()).append("   ").append("Armor Rating: ").append(item.getDefRating()).append("\n");
        }
        return builder.toString();
    }

}
