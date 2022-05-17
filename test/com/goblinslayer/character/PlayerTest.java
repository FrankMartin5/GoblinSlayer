package com.goblinslayer.character;

import com.goblinslayer.character.Player;
import com.goblinslayer.character.Weapon;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    private Player player;
    private Monster monster;

    @Before
    public void setUp() {
        player = new Player("p1", 50, Weapon.AXE);
    }

    @Test
    public void testAttack() {
        assertEquals(15, player.attack(monster));
    }

    @Test
    public void testDefend() {
        assertEquals(0, player.defend());
    }
}
