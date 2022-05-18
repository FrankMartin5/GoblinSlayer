package com.goblinslayer.app;

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
        //app.createPlayer();
        app.shopForArmor();
        //app.thirdEncounter();
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
                int selection = Integer.parseInt(scanner.next());
                switch (selection) {
                    case 1:
                        if (p1.getWallet() >= armor.findById(1).getPrice()) {
                            change = armor.sellArmor(p1.getWallet(), selection);
                            p1.setDefense(armor.findById(1).getDefRating());
                            TimeUnit.MILLISECONDS.sleep(2500);
                            System.out.println("You purchased the cloth armor for $" + armor.findById(1).getPrice() + ". You now have $" + change + " left in your wallet.");
                            System.out.println();
                            TimeUnit.MILLISECONDS.sleep(2500);
                            System.out.println("As you put on your armor you smell a strange but strong odor that reminds you of rat piss.");
                            System.out.println();
                            TimeUnit.MILLISECONDS.sleep(2500);
                            System.out.println("You bump into a child as you walk out of the store which results in them running away screaming that you touched them.");
                            System.out.println();
                            TimeUnit.MILLISECONDS.sleep(3500);
                            System.out.println("You are chased out of town.");
                            System.out.println();
                            choseArmor = false;
                        } else {
                            System.out.println("You can't afford this armor! You only have $" + p1.getWallet() + "! Going back to armor selection...");
                        }
                        break;
                    case 2:
                        if (p1.getWallet() >= armor.findById(2).getPrice()) {
                            change = armor.sellArmor(p1.getWallet(), selection);
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
                            change = armor.sellArmor(p1.getWallet(), selection);
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
                            change = armor.sellArmor(p1.getWallet(), selection);
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
        System.out.println("Your players defense is now " + p1.getDefense() + ". Now, go save you a princess.");
    }

    public void thirdEncounter() throws InterruptedException {
        // holds the games art
        String rock = "    Rock\n" +
                "---'   ____)\n" +
                "      (_____)\n" +
                "      (_____)\n" +
                "      (____)\n" +
                "---.__(___)";

        String paper = "   Paper\n" +
                "---'   ____)____\n" +
                "          ______)\n" +
                "          _______)\n" +
                "         _______)\n" +
                "---.__________)";
        String scissor = "   scissor\n" +
                "---'   ____)____\n" +
                "          ______)\n" +
                "          _______)\n" +
                "         _______)\n" +
                "---.__________)";
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
                            "        \\/            \\//_____/            \\/                     \\/                    \\/     \\/ \\/  \\/                            \\/          \\/\\/");
                    gameContinue = false;

                } else if (lostGames == 2) {
                    System.out.println(
                            "You Lost to the Goblin King...\n" +
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
                            "You Lost to the Goblin King...\n" +
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

