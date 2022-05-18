package com.goblinslayer.app;

import com.goblinslayer.character.Monster;
import com.goblinslayer.character.MonsterType;
import com.goblinslayer.character.Player;
import com.goblinslayer.character.Weapon;
import com.goblinslayer.shop.ArmorShop;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GoblinSlayerApp {
    Player p1 = new Player();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        GoblinSlayerApp app = new GoblinSlayerApp();
        app.createPlayer();
        app.shopForArmor();
        app.monsterFight();
        app.thirdEncounter();
    }

    public void createPlayer() {
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

    public void shopForArmor() {
        ArmorShop armor = new ArmorShop();
        boolean choseArmor = true;
        System.out.println();
        System.out.println("You decide to stop by the town shop to purchase armor before you embark on your quest to save the princess.");
        System.out.println();
        System.out.println("While visiting the shop you notice that there are 4 different sets of armor on the wall");
        System.out.println();
        System.out.println(armor.toString());

        while (choseArmor) {
            System.out.println("Which armor do you want to purchase on your quest? Cloth[1], Leather[2], Steel[3], or Gold Plated[4]");
            String selection = scanner.next();
            switch (selection) {
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
        System.out.println();
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
                if (p1.getHp() > 1) {
                    System.out.println("\t Your current hp is " + p1.getHp());
                } else if (p1.getHp() < 1) {
                    System.out.println("Too much damage taken! You're too weak to continue");
                    p1.setHp(50);
                    monsterFight();
                    break;
                }
            } else if (input.equals("2")) {
                p1.defend();
                monster.attack(p1);

                System.out.println("\t You defended against the " + monster.getMonsterType() +". Monster has " + monster.getHp()+ "left");
                if (p1.getHp() > 1) {
                    System.out.println("\t Your current hp is " + p1.getHp());
                } else if (p1.getHp() < 1) {
                    System.out.println("Too much damage taken! You're too weak to continue");
                    p1.setHp(50);
                    monsterFight();
                    break;
                }
            }
        }
        System.out.println();
        System.out.println("You won the battle!");
        System.out.println();
    }

    public void thirdEncounter() throws InterruptedException {
        // holds the games art
        String rock = "  Rock\n" +
                "---'   ____)\n" +
                "      (_____)\n" +
                "      (_____)\n" +
                "      (____)\n" +
                "---.__(___)";

        String paper = " Paper\n" +
                "---'   ____)____\n" +
                "          ______)\n" +
                "          _______)\n" +
                "         _______)\n" +
                "---.__________)";
        String scissor = "Scissor\n" +
                "    _______\n" +
                "---'   ____)____\n" +
                "          ______)\n" +
                "       __________)\n" +
                "      (____)\n" +
                "---.__(___)\n";

        // build up for the game.
        System.out.println("After narrowly escaping defeat at the hands of that monster you finally enter into " +
                "the goblin kings lair...");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("The Goblin King leers at you, and challenges you to the game for your life.  " +
                "Rock-Paper-Scissors.  A test fit for a true warrior.");
        TimeUnit.MILLISECONDS.sleep((1500));
        System.out.println("Are you ready " + p1.getName() + "?");

        boolean gameContinue = true;
        String[] gameImages = {rock, paper, scissor};
        int wonGames = 0;
        int lostGames = 0;

        // loop that continues the game as long as two wins or loses has not been counted
        while (gameContinue) {
            System.out.println("Please choice [0] for rock, [1] for paper, or [2] for scissor." +
                    " It is best of three, current wins: " + wonGames + " current loses: " + lostGames);

            try {
                int userChoice = 0;
                userChoice = Integer.parseInt(scanner.next());
                int computerChoice = (int) Math.floor(Math.random() * (3));
                if (userChoice >= 3 || userChoice < 0) {
                    System.out.println(" You chose an invalid option!  You lose this round, try again.");
                    //gameContinue = false;
                    lostGames++;
                } else if (userChoice == 0 && computerChoice == 2) {
                    System.out.println("Computer chose " + gameImages[computerChoice]);
                    System.out.println("You chose " + gameImages[userChoice]);
                    System.out.println("You Win this round!");
                    wonGames++;
                } else if (computerChoice == 0 && userChoice == 2) {
                    System.out.println("Computer chose " + gameImages[computerChoice]);
                    System.out.println("You chose " + gameImages[userChoice]);
                    System.out.println("You lost this round!");
                    lostGames++;
                } else if (computerChoice > userChoice) {
                    System.out.println("Computer chose " + gameImages[computerChoice]);
                    System.out.println("You chose " + gameImages[userChoice]);
                    System.out.println("You lost this round!");
                    lostGames++;
                } else if (userChoice > computerChoice) {
                    System.out.println("Computer chose " + gameImages[computerChoice]);
                    System.out.println("You chose " + gameImages[userChoice]);
                    System.out.println("You Win this round!");
                    wonGames++;

                } else if (computerChoice == userChoice) {
                    System.out.println("Computer chose " + gameImages[computerChoice]);
                    System.out.println("You chose " + gameImages[userChoice]);
                    System.out.println("Draw try gain..");
                } else {
                    System.out.println(" You chose an invalid option!  You lose this round, try again.");
                    lostGames++;
                }

                // Break
                if (wonGames == 2) {
                    System.out.println("_________                                     __        .__          __  .__                     ._. _____.___.               __      __.__      ._.\n" +
                            "\\_   ___ \\  ____   ____    ________________ _/  |_ __ __|  | _____ _/  |_|__| ____   ____   _____| | \\__  |   | ____  __ __  /  \\    /  \\__| ____| |\n" +
                            "/    \\  \\/ /  _ \\ /    \\  / ___\\_  __ \\__  \\\\   __\\  |  \\  | \\__  \\\\   __\\  |/  _ \\ /    \\ /  ___/ |  /   |   |/  _ \\|  |  \\ \\   \\/\\/   /  |/    \\ |\n" +
                            "\\     \\___(  <_> )   |  \\/ /_/  >  | \\// __ \\|  | |  |  /  |__/ __ \\|  | |  (  <_> )   |  \\\\___ \\ \\|  \\____   (  <_> )  |  /  \\        /|  |   |  \\|\n" +
                            " \\______  /\\____/|___|  /\\___  /|__|  (____  /__| |____/|____(____  /__| |__|\\____/|___|  /____  >__  / ______|\\____/|____/    \\__/\\  / |__|___|  /_\n" +
                            "        \\/            \\//_____/            \\/                     \\/                    \\/     \\/ \\/  \\/                            \\/          \\/\\/\n" +
                            "You defeated the Goblin King, sent him packin', and saved the day!");
                    gameContinue = false;

                } else if (lostGames == 2) {
                    System.out.println(
                            "You Lost to the Goblin King...He swallowed you whole, and laughed.\n" +
                                    " ________                        ________                    ._._.\n" +
                                    " /  _____/_____    _____   ____   \\_____  \\___  __ ___________| | |\n" +
                                    "/   \\  ___\\__  \\  /     \\_/ __ \\   /   |   \\  \\/ // __ \\_  __ \\ | |\n" +
                                    "\\    \\_\\  \\/ __ \\|  Y Y  \\  ___/  /    |    \\   /\\  ___/|  | \\/\\|\\|\n" +
                                    " \\______  (____  /__|_|  /\\___  > \\_______  /\\_/  \\___  >__|   ____\n" +
                                    "        \\/     \\/      \\/     \\/          \\/          \\/       \\/\\/");
                    gameContinue = false;
                }

            } catch (NumberFormatException e) { // catch all, for any input that is not an int.
                System.out.println(" You chose an invalid option!  You lose this round, try again.");
                lostGames++;
                if (lostGames == 2){
                    System.out.println(
                            "You Lost to the Goblin King...He swallowed you whole, and laughed.\n" +
                                    " ________                        ________                    ._._.\n" +
                                    " /  _____/_____    _____   ____   \\_____  \\___  __ ___________| | |\n" +
                                    "/   \\  ___\\__  \\  /     \\_/ __ \\   /   |   \\  \\/ // __ \\_  __ \\ | |\n" +
                                    "\\    \\_\\  \\/ __ \\|  Y Y  \\  ___/  /    |    \\   /\\  ___/|  | \\/\\|\\|\n" +
                                    " \\______  (____  /__|_|  /\\___  > \\_______  /\\_/  \\___  >__|   ____\n" +
                                    "        \\/     \\/      \\/     \\/          \\/          \\/       \\/\\/");
                    gameContinue = false;

                }
            }
        }
    }

}

