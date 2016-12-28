package com.website.games;

public class PunchMachine extends Character {
    private static String winner;

    private PunchMachine(String name, int health, int strength) {
        super(name, health, strength);
    }

    private static void setWinner(String name) {
        winner = name;
    }

    private static void printWinner() {
        System.out.println("The winner is " + winner + "!");
    }

    private static void combat(Character player0, Character player1) {
        System.out.printf("Punch Contest: %s vs. %s%n%n", player0.getName(), player1.getName()); 

        player0.printStats();
        player1.printStats();

        while (player0.getHealth() > 0 && player1.getHealth() > 0) {
            player1.takeDamage(player0.attack());

            if (player1.getHealth() <= 0) {
                setWinner(player0.getName());
                break;
            }

            player0.takeDamage(player1.attack());

            if (player0.getHealth() <= 0) {
                setWinner(player1.getName());
                break;
            }
        }
    }

    public static void main(String[] args) {
        Character hero = new Character("Tom", 20, 5);
        Character monster = new Character("Gorlav", 15, 4);

        combat(hero, monster);

        printWinner();
    }
}
