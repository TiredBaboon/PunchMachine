public class Character {
    public int health;
    public int strength;
    public String name;

    public Character(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
    }

    public int attack() {
        System.out.println(this.name + " is attacking with " + this.strength + " damage!");
        return this.strength;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println(this.name + " took " + damage + " damage.");
        System.out.println(this.name + "'s health: " + this.health);
        System.out.println();
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
        System.out.println("===== " + this.name + "'s stats =====");
        System.out.println("Health: " + this.health);
        System.out.println("Strength: " + this.strength);
        System.out.println();
    }
}
