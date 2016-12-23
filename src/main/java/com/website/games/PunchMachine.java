import java.lang.Thread;

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

    private static void waitFor(long time) {
        Thread thread = new Thread();

        try {
            thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {
        Character hero = new Character("Tom", 20, 5);
        Character monster = new Character("Gorlav", 15, 4);

        hero.printStats();
        monster.printStats();

        while (hero.getHealth() > 0 && monster.getHealth() > 0) {
            monster.takeDamage(hero.attack());

            if (monster.getHealth() <= 0) {
                setWinner(hero.getName());
                break;
            }

            waitFor(1500);

            hero.takeDamage(monster.attack());

            if (hero.getHealth() <= 0) {
                setWinner(monster.getName());
                break;
            }
    
            waitFor(1500);
        }

        printWinner();
    }
}
