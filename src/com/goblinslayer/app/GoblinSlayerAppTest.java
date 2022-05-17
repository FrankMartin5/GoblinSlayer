package com.goblinslayer.app;

import com.goblinslayer.character.Monster;
import com.goblinslayer.character.Player;
import com.goblinslayer.character.Weapon;

import java.util.Scanner;

public class GoblinSlayerAppTest {
    Player p1 = new Player();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GoblinSlayerAppTest app = new GoblinSlayerAppTest();
        app.createPlayer();
    }

    public void createPlayer(){
        boolean badWeapon = true;
        String name;
        System.out.println("Please enter your Name...");
        name = scanner.nextLine();
        while (badWeapon) {
            Weapon weapon = null;
            System.out.println("What is your desired Weapon... [1]Axe, [2]Sword, [3] Staff, [4] Club");
            String selection = scanner.next();
            switch (selection) {
                case ("1"):
                    p1.setWeapon(Weapon.AXE);
                    badWeapon = false;
                    break;
                case ("2"):
                    p1.setWeapon(Weapon.SWORD);
                    badWeapon = false;
                    break;
                case ("3"):
                    p1.setWeapon(Weapon.STAFF);
                    badWeapon = false;
                    break;
                case ("4"):
                    p1.setWeapon(Weapon.CLUB);
                    badWeapon = false;
                    break;
                default:
                    p1.setWeapon(Weapon.STICK);
            }
        }
        p1 = new Player(name, 50, p1.getWeapon());
        System.out.println("You player's stats are: " + p1.toString());
    }

    public void monsterFight() {
        System.out.println("After stopping by the famed Armor Shop you are now ready to slay Goblins\n");
        System.out.println("We have now entered a mysterious cave and you notice the princess's shoe\n\n");
        System.out.println("Oh No looks like you're being attacked!");


        Monster randomMonster = new Monster();

    }
}
