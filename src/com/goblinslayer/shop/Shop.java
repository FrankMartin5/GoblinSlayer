package com.goblinslayer.shop;

import java.util.Collection;

public interface Shop {

    public Armor findById(Integer id);

    public Collection<Armor> findByArmorName(String name);

    public Collection<Armor> listAllArmor();

    public int sellArmor(int money, Integer id);

    public void armorTable();

}
