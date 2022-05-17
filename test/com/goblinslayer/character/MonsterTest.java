package com.goblinslayer.character;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MonsterTest {
    private Monster monster;
    private Player player;

    @Before
    public void setUp() {
        monster =  new Monster(20, MonsterType.WEREWOLF);
    }

    @Test
    public void testAttack() {
        assertEquals(100, monster.attack(monster));
    }

    @Test
    public void testDefend() {
        assertEquals(5, monster.defend());
    }

}
