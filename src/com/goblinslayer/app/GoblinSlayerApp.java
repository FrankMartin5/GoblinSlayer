package com.goblinslayer.app;

import com.goblinslayer.character.Player;
import com.goblinslayer.character.Weapon;
import com.goblinslayer.shop.ArmorShop;

import java.util.Scanner;

public class GoblinSlayerApp {
    Player p1 = new Player();
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        GoblinSlayerApp app = new GoblinSlayerApp();
        // app.createPlayer();
        // app.shopForArmor();
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
    }

