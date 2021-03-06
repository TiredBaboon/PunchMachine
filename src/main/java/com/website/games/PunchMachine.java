package com.website.games;

public class PunchMachine {
    public static void main(String[] args) {
        Character hero = new Character("Tom", 20, 5, 50, 2);
        Character monster = new Character("Gorlav", 15, 4, 50, 2);
        Character monster2 = new Character("Ulav");

        combat(hero, monster);
        combat(hero, monster2);
    }

    private static void combat(Character player0, Character player1) {
        System.out.printf("Punch Contest: %s vs. %s%n%n", player0.getName(), player1.getName()); 

        player0.printStats();
        player1.printStats();

        while (player0.getHealth() > 0 && player1.getHealth() > 0) {
            player1.defend(player0.attack());

            if (!player1.getIsAlive()) {
                printWinner(player0.getName());
                break;
            }

            player0.defend(player1.attack());

            if (!player0.getIsAlive()) {
                printWinner(player1.getName());
                break;
            }
        }
    }

    private static void printWinner(String winner) {
        System.out.printf("The winner is %s!%n%n", winner);
    }
}
