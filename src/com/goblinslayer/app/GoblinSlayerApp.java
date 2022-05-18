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
        app.welcome();
        app.createPlayer();
        app.shopForArmor();
        app.monsterFight();
        app.bossFight();
    }
    public void welcome() throws InterruptedException {
        System.out.println("Welcome to: ");
        System.out.println("  ▄████  ▒█████   ▄▄▄▄    ██▓     ██▓ ███▄    █      ██████  ██▓    ▄▄▄     ▓██   ██▓▓█████  ██▀███  \n" +
                " ██▒ ▀█▒▒██▒  ██▒▓█████▄ ▓██▒    ▓██▒ ██ ▀█   █    ▒██    ▒ ▓██▒   ▒████▄    ▒██  ██▒▓█   ▀ ▓██ ▒ ██▒\n" +
                "▒██░▄▄▄░▒██░  ██▒▒██▒ ▄██▒██░    ▒██▒▓██  ▀█ ██▒   ░ ▓██▄   ▒██░   ▒██  ▀█▄   ▒██ ██░▒███   ▓██ ░▄█ ▒\n" +
                "░▓█  ██▓▒██   ██░▒██░█▀  ▒██░    ░██░▓██▒  ▐▌██▒     ▒   ██▒▒██░   ░██▄▄▄▄██  ░ ▐██▓░▒▓█  ▄ ▒██▀▀█▄  \n" +
                "░▒▓███▀▒░ ████▓▒░░▓█  ▀█▓░██████▒░██░▒██░   ▓██░   ▒██████▒▒░██████▒▓█   ▓██▒ ░ ██▒▓░░▒████▒░██▓ ▒██▒\n" +
                " ░▒   ▒ ░ ▒░▒░▒░ ░▒▓███▀▒░ ▒░▓  ░░▓  ░ ▒░   ▒ ▒    ▒ ▒▓▒ ▒ ░░ ▒░▓  ░▒▒   ▓▒█░  ██▒▒▒ ░░ ▒░ ░░ ▒▓ ░▒▓░\n" +
                "  ░   ░   ░ ▒ ▒░ ▒░▒   ░ ░ ░ ▒  ░ ▒ ░░ ░░   ░ ▒░   ░ ░▒  ░ ░░ ░ ▒  ░ ▒   ▒▒ ░▓██ ░▒░  ░ ░  ░  ░▒ ░ ▒░\n" +
                "░ ░   ░ ░ ░ ░ ▒   ░    ░   ░ ░    ▒ ░   ░   ░ ░    ░  ░  ░    ░ ░    ░   ▒   ▒ ▒ ░░     ░     ░░   ░ \n" +
                "      ░     ░ ░   ░          ░  ░ ░           ░          ░      ░  ░     ░  ░░ ░        ░  ░   ░     \n" +
                "                       ░                                                     ░ ░                     ");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("The console based RPG.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("The Goblin King has captured your beloved princess, and stolen her away to his cave.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Your mission is to save her by defeating the Goblin King and his minions.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println();

    }

    public void createPlayer() throws InterruptedException {
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
                    badWeapon = false;
                    break;
            }
        }
        p1 = new Player(name, 50, p1.getWeapon());
        System.out.println("You player's stats are: " + p1.toString());
        TimeUnit.MILLISECONDS.sleep(2000);

    }

    public void shopForArmor() throws InterruptedException {
        ArmorShop armor = new ArmorShop();
        boolean choseArmor = true;
        System.out.println();
        System.out.println("You decide to stop by the town shop to purchase armor before you embark on your quest to save the princess.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2500);
        System.out.println("While visiting the shop you notice that there are 4 different sets of armor on the wall");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2500);
        armor.armorTable();
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2500);
        System.out.println("The current amount in your wallet is: $" + p1.getWallet());


        while (choseArmor) {
            try {
                int change = 0;
                TimeUnit.MILLISECONDS.sleep(2500);
                System.out.println();
                System.out.println("Which armor do you want to purchase on your quest?  Cloth[1], Leather[2], Steel[3], Gold Plated[4], or No Armor[0] (in case you really want to impress the princess when you save her.)");
                System.out.println();
                System.out.println("Enter your selection here: ");
                int input = Integer.parseInt(scanner.next());
                switch (input) {
                    case 1:
                        if (p1.getWallet() >= armor.findById(1).getPrice()) {
                            change = armor.sellArmor(p1.getWallet(), input);
                            p1.setDefense(armor.findById(1).getDefRating());
                            TimeUnit.MILLISECONDS.sleep(2500);
                            System.out.println("You purchased the cloth armor for $" + armor.findById(1).getPrice() + ". You now have $" + change + " left in your wallet.");
                            System.out.println();
                            TimeUnit.MILLISECONDS.sleep(2500);
                            System.out.println("As you put on your armor you smell a strange but strong odor that reminds you of rat piss.");
                            System.out.println();
                            choseArmor = false;
                        } else {
                            System.out.println("You can't afford this armor! You only have $" + p1.getWallet() + "! Going back to armor selection...");
                        }
                        break;
                    case 2:
                        if (p1.getWallet() >= armor.findById(2).getPrice()) {
                            change = armor.sellArmor(p1.getWallet(), input);
                            p1.setDefense(armor.findById(2).getDefRating());
                            TimeUnit.MILLISECONDS.sleep(2500);
                            System.out.println("You purchased the leather armor for $" + armor.findById(2).getPrice() + ". You now have $" + change + " left in your wallet.");
                            System.out.println();
                            TimeUnit.MILLISECONDS.sleep(2500);
                            System.out.println("The fit is tight around the crotch but you should manage.");
                            System.out.println();
                            TimeUnit.MILLISECONDS.sleep(2500);
                            System.out.println("The shop keep smacks your butt and winks at you as you leave the store...");
                            System.out.println();
                            TimeUnit.MILLISECONDS.sleep(2500);
                            System.out.println("You feel violated.");
                            System.out.println();
                            choseArmor = false;
                        } else {
                            System.out.println("You can't afford this armor! You only have $" + p1.getWallet() + "! Going back to armor selection...");
                        }
                        break;
                    case 3:
                        if (p1.getWallet() >= armor.findById(3).getPrice()) {
                            change = armor.sellArmor(p1.getWallet(), input);
                            p1.setDefense(armor.findById(3).getDefRating());
                            TimeUnit.MILLISECONDS.sleep(2500);
                            System.out.println("You purchased the steel armor for $" + armor.findById(3).getPrice() + ". You now have $" + change + " left in your wallet.");
                            System.out.println();
                            TimeUnit.MILLISECONDS.sleep(2500);
                            System.out.println("Your testosterone boosted 20 fold when you put the armor on.");
                            System.out.println();
                            TimeUnit.MILLISECONDS.sleep(2500);
                            System.out.println("You notice the local women in town swooning over you as you leave the store");
                            System.out.println();
                            TimeUnit.MILLISECONDS.sleep(2500);
                            System.out.println("You feel like a million shillings.");
                            System.out.println();
                            choseArmor = false;
                        } else {
                            System.out.println("You can't afford this armor! You only have $" + p1.getWallet() + "! Going back to armor selection...");
                        }
                        break;
                    case 4:
                        if (p1.getWallet() >= armor.findById(4).getPrice()) {
                            change = armor.sellArmor(p1.getWallet(), input);
                            p1.setDefense(armor.findById(4).getDefRating());
                            TimeUnit.MILLISECONDS.sleep(2500);
                            System.out.println("You purchased the gold plated armor for $" + armor.findById(4).getPrice() + ". You now have $" + change + " left in your wallet.");
                            System.out.println();
                            TimeUnit.MILLISECONDS.sleep(2500);
                            System.out.println("As you put the armor on you grow a full beard, acquire bigger muscle, and notice your voice sounds like Charlie Hunnam");
                            System.out.println();
                            TimeUnit.MILLISECONDS.sleep(2500);
                            System.out.println("The town is blinded by your armor, and all bow down to your brilliance");
                            System.out.println();
                            TimeUnit.MILLISECONDS.sleep(2500);
                            System.out.println("You are now a god.");
                            System.out.println();
                            choseArmor = false;
                        } else {
                            System.out.println("You can't afford this armor! You only have $" + p1.getWallet() + "! Going back to armor selection...");
                        }
                        break;
                    case 0:
                        TimeUnit.MILLISECONDS.sleep(1500);
                        System.out.println("You decided to have no armor because you're a hard body and you know the princess is going to dig that.");
                        choseArmor = false;
                        break;
                    default:
                        System.out.println("Invalid argument, try to stay in the range of 0-4. Going back to armor selection...");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid argument, try to stay in the range of 0-4. Going back to armor selection...");
            }
        }
        TimeUnit.MILLISECONDS.sleep(2500);
    }


    public void monsterFight() throws InterruptedException {
        Monster monster = new Monster();
        System.out.println();
        System.out.println("After stopping by the famed Armor Shop you stumbled upon the cave the princess is being held.\n");
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

        System.out.println("Oh No! You ran into a " + monster.getMonsterType());

        while (monster.getHp() > 0) {
            System.out.println("\t What would you like to do? [1]Attack or [2] Defend");
            System.out.println("\t Your current stats are HP:" + p1.getHp() + " Power: " + p1.getWeapon().getPower()+".");
            System.out.println("\t "+ monster.getMonsterType() + " stats are " + "HP: "+ monster.getHp() +" "+ "Power: "+monster.getMonsterType().getPower()+".");

            String input = scanner.next();
            if (input.equals("1")) {
                p1.attack(monster);
                monster.attack(p1);

                System.out.println("\t You attacked the " + monster.getMonsterType() + ".");
                if (p1.getHp() > 1) {
                    System.out.println("\t Your current hp is " + p1.getHp()+".");
                    System.out.println();
                } else if (p1.getHp() < 1) {
                    System.out.println("Oh no, this monster was too strong! You blacked out and woke up in front of the cave.\n");
                    p1.setHp(50);
                    monsterFight();
                    break;
                }
            } else if (input.equals("2")) {
                p1.defend(monster);
                monster.attack(p1);

                System.out.println("\t You defended against the " + monster.getMonsterType() + ". Monster has " + monster.getHp() + " HP left.");
                if (p1.getHp() > 1) {
                    System.out.println("\t Your current hp is " + p1.getHp()+".");
                    System.out.println();
                } else if (p1.getHp() < 1) {
                    System.out.println("Oh no, this monster was too strong! You blacked out and woke up in front of the cave.\n");
                    p1.setHp(50);
                    monsterFight();
                    break;
                }
            }
        }
        System.out.println();
        System.out.println("You won the battle!\n");

    }

    public void bossFight() throws InterruptedException {

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
        TimeUnit.MILLISECONDS.sleep(3000);
        System.out.println("After narrowly escaping defeat at the hands of that monster you finally enter into " +
                "the goblin kings lair...");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("\n" +
                "                           __,='`````'=/__\n" +
                "                          '//  (o) \\(o) \\ `'         _,-,\n" +
                "                          //|     ,_)   (`\\      ,-'`_,-\\\n" +
                "                        ,-~~~\\  `'==='  /-,      \\==```` \\__\n" +
                "                       /        `----'     `\\     \\       \\/\n" +
                "                    ,-`                  ,   \\  ,.-\\       \\\n" +
                "                   /      ,               \\,-`\\`_,-`\\_,..--'\\\n" +
                "                  ,`    ,/,              ,>,   )     \\--`````\\\n" +
                "                  (      `\\`---'`  `-,-'`_,<   \\      \\_,.--'`\n" +
                "                   `.      `--. _,-'`_,-`  |    \\\n" +
                "                    [`-.___   <`_,-'`------(    /\n" +
                "                    (`` _,-\\   \\ --`````````|--`\n" +
                "                     >-`_,-`\\,-` ,          |\n" +
                "                   <`_,'     ,  /\\          /\n" +
                "                    `  \\/\\,-/ `/  \\/`\\_/V\\_/\n" +
                "                       (  ._. )    ( .__. )\n" +
                "                       |      |    |      |\n" +
                "                        \\,---_|    |_---./\n" +
                "                        ooOO(_)    (_)OOoo");
        System.out.println("The Goblin King leers at you, and challenges you to the game for your life...");
        TimeUnit.MILLISECONDS.sleep(2500);
        System.out.println("Rock-Paper-Scissors, A test fit for a true warrior");
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
                if (lostGames == 2) {
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

