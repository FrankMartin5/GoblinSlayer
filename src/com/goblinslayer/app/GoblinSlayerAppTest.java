package com.goblinslayer.app;

import com.goblinslayer.character.Monster;
import com.goblinslayer.character.MonsterType;
import com.goblinslayer.character.Player;
import com.goblinslayer.character.Weapon;
import com.goblinslayer.shop.ArmorShop;

import javax.swing.text.SimpleAttributeSet;
import java.util.Scanner;
import java.util.SortedMap;

public class GoblinSlayerAppTest {
    Player p1 = new Player();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GoblinSlayerAppTest app = new GoblinSlayerAppTest();
        app.createPlayer();
        app.shopForArmor();
        app.monsterFight();
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

    public void shopForArmor(){
        ArmorShop armor = new ArmorShop();
        boolean choseArmor = true;
        System.out.println();
        System.out.println("You decide to stop by the town shop to purchase armor before you embark on your quest to save the princess.");
        System.out.println();
        System.out.println("While visiting the shop you notice that there are 4 different sets of armor on the wall");
        System.out.println();
        System.out.println(armor.toString());

        while(choseArmor){
            System.out.println("Which armor do you want to purchase on your quest? Cloth[1], Leather[2], Steel[3], or Gold Plated[4]");
            String selection = scanner.next();
            switch(selection){
                case "1":
                    p1.setDefense(armor.findById(1).getDefRating());
                    System.out.println("You chose Cloth Armor");
                    choseArmor = false;
                    break;
                case "2":
                    p1.setDefense(armor.findById(2).getDefRating());
                    System.out.println("You chose Leather Armor");
                    choseArmor = false;
                    break;
                case "3":
                    p1.setDefense(armor.findById(3).getDefRating());
                    System.out.println("You chose Steel Armor");
                    choseArmor = false;
                    break;
                case "4":
                    p1.setDefense(armor.findById(4).getDefRating());
                    System.out.println("You chose Gold Plated Armor");
                    choseArmor = false;
                    break;
                default:
                    System.out.println("You've decided that you didn't need any armor because you're a hard body.");
                    choseArmor = false;

            }
        }
        System.out.println("You player's stats are: " + p1.toString());
    }

    public void monsterFight() {
        Monster monster = new Monster();
        boolean gameLoop = true;
        System.out.println("After stopping by the famed Armor Shop you are now ready to slay Goblins and save the Princess\n");
        System.out.println("What route will you take as you enter the cave?  [1]Left, [2]Middle, [3] Right");

        String selection = scanner.next();
        switch (selection) {
            case ("1"):
                monster = new Monster(50, MonsterType.GOBLIN);
                break;
            case ("2"):
                monster = new Monster(50, MonsterType.WEREWOLF);
                break;
            case ("3"):
                monster = new Monster(50, MonsterType.ZOMBIE);
                break;
            default:
                System.out.println("Please select [1]Left, [2]Middle, [3] Right");
                break;
        }

        System.out.println("Oh No! You ran into a "+ monster.getMonsterType());

        while (monster.getHp() > 0) {
            System.out.println("\t Your HP: " + p1.getHp());
            System.out.println("\t "+ monster.getMonsterType() + "'s HP: " + monster.getHp());
            System.out.println("\n\tWhat would you like to do");
            System.out.println("\t1. Attack");
            System.out.println("\t2. Defend");

            String input = scanner.nextLine();
            if (input.equals("1")) {
                p1.attack(monster);
                monster.attack(p1);

                System.out.println("\t You attacked the " + monster.getMonsterType()+".");
                System.out.println("\t Your current hp is " + p1.getHp());
                if (p1.getHp() < 1) {
                    System.out.println("Too much damage taken! You're too weak to continue");
                    break;
                }
            } else if (input.equals("2")) {
                p1.defend();
                monster.attack(p1);

                System.out.println("\t You defended against the " + monster.getMonsterType() +". Monster has " + monster.getHp()+ "left");
                System.out.println("\t Your current hp is " + p1.getHp());
                if (p1.getHp() < 1) {
                    System.out.println("Too much damage taken! You're too weak to continue");
                    break;
                }
            } else {
                System.out.println("wrong input");
            }
        }

        System.out.println();
        System.out.println("Looks like you made it back alive!!!");
        System.out.println("Your current stats after battle are: " + p1.toString());



    }
}