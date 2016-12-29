package com.website.games;

import java.util.concurrent.ThreadLocalRandom;

public class Character {
    public int health;
    public int strength;
    public int accuracy;
    public int minAttack;
    public int maxAttack;
    public boolean isAlive;
    public String name;

    public Character(String name) {
        this.name = name;
        this.health = 10;
        this.accuracy = 50;
        this.minAttack = 1;
        this.strength = this.maxAttack = 3;
        this.isAlive = true;
    }

    public Character(String name, int health, int strength, int accuracy, int minAttack) {
        this.name = name;
        this.health = health;
        this.accuracy = accuracy;
        this.minAttack = minAttack;
        this.strength = this.maxAttack = strength;
    }

    public boolean checkAccuracy() {
        int check = ThreadLocalRandom.current().nextInt(1, 101);

        if (check <= this.accuracy) {
            return true;
        } else {
            return false;
        }
    }

    public int attack() {
        boolean landBlow = this.checkAccuracy();

        if (landBlow) {
            int damage = ThreadLocalRandom.current().nextInt(this.minAttack, this.maxAttack + 1);

            System.out.printf("%s damage dealt: %d%n", this.name, damage);

            return damage;
        } else {
            System.out.printf("%s missed.%n", this.name);

            return 0;
        }
    }

    public void defend(int damage) {
        this.health -= damage;

        if(this.health <= 0) {
            this.isAlive = false;
        }

        System.out.printf("%s damage taken: %d%n", this.name, damage);
        System.out.printf("%s's health: %d%n%n", this.name, this.health);
    }

    public boolean getIsAlive() {
        return this.isAlive;
    }

    public int getHealth() {
        return this.health;
    }

    public int getStrength() {
        return this.strength;
    }

    public String getName() {
        return this.name;
    }

    public void printStats() {
        System.out.printf("===== %s's stats =====%n", this.name);
        System.out.printf("Health: %d%n", this.health);
        System.out.printf("Strength: %d%n%n", this.strength);
    }
}
