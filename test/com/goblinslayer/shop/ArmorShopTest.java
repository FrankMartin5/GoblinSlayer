package com.goblinslayer.shop;

import junit.framework.TestCase;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;

public class ArmorShopTest extends TestCase {

    public void setUp() {
        Collection<Armor> result = new ArrayList<>();
        ArmorShop armor = new ArmorShop();
    }

    public void testListAllArmor() {
        ArmorShop armor = new ArmorShop();
        assertEquals(4, armor.listAllArmor().size());
    }

    public void testFindById() {
        ArmorShop armor = new ArmorShop();
        System.out.println(armor.findById(3));

    }

    public void testFindByArmorName() {
        ArmorShop armor = new ArmorShop();
        System.out.println(armor.findByArmorName("armor"));
    }
}