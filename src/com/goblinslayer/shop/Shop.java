package com.goblinslayer.shop;

import java.util.Collection;

public interface Shop {

    public Armor findById(Integer id);

    public Collection<Armor> findByArmorName(String name);

    public Collection<Armor> listAllArmor();


}
