package com.goblinslayer.shop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArmorShop implements Shop {


    private List<Armor> armorInventory = new ArrayList<>(List.of(
            new Armor(1, "Cloth Armor", 20, 5),
            new Armor(2, "Leather Armor", 50, 10),
            new Armor(3, "Steel Armor", 100, 15),
            new Armor(4, "Gold Plated Armor", 200, 20)
    ));


    @Override
    public Collection<Armor> listAllArmor() {
        Collection<Armor> result = new ArrayList<>();
        for (Armor item : armorInventory) {
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
    public void armorTable(){
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%20s %10s %20s", "NAME", "PRICE", "DEFENSE RATING");
        System.out.println();
        System.out.println("------------------------------------------------------------------");
        for(Armor armor: armorInventory){
            System.out.format("%20s %10s %20d", armor.getItemName(), "$" + armor.getPrice(), armor.getDefRating());
            System.out.println();
        }
        System.out.println("------------------------------------------------------------------");
    }

    @Override
    public int sellArmor(int money, Integer id) {
        int result = 0;
        double armorPrice = findById(id).getPrice();
        if (money >= armorPrice) {
            result = (int) (money - armorPrice);
        }

        return result;
    }
}
