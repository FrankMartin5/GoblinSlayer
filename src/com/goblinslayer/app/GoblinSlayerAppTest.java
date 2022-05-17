package com.goblinslayer.app;

import com.goblinslayer.character.Monster;
import com.goblinslayer.character.MonsterType;
import com.goblinslayer.character.Player;
import com.goblinslayer.character.Weapon;

import javax.swing.text.SimpleAttributeSet;
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
        Monster m1 = new Monster();
        System.out.println("After stopping by the famed Armor Shop you are now ready to slay Goblins and save the Princess\n");
        System.out.println("What route will you take as you enter the cave?  [1]Left, [2]Middle, [3] Right");

        String selection = scanner.next();
        switch (selection) {
            case ("1"):
                m1 = new Monster(50, MonsterType.GOBLIN);
                break;
            case ("2"):
                m1 = new Monster(50, MonsterType.WEREWOLF);
                break;
            case ("3"):
                m1 = new Monster(50, MonsterType.ZOMBIE);
                break;
            default:
                System.out.println("Please select [1]Left, [2]Middle, [3] Right");
                break;
        }


        System.out.println();


    }
}
