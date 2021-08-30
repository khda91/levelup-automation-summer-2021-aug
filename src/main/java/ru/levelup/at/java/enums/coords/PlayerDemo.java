package ru.levelup.at.java.enums.coords;

public class PlayerDemo {

    public static void main(String[] args) {
        Player snoopy = new Player("snoopy");
        System.out.printf("Current position of player %s is x: %d || y: %d %n",
            snoopy.getName(), snoopy.getX(), snoopy.getY());

        System.out.println("Press keyboard arrow UP");
        snoopy.move(Direction.NORTH);
        System.out.printf("Current position of player %s is x: %d || y: %d %n",
            snoopy.getName(), snoopy.getX(), snoopy.getY());

        System.out.println("Press keyboard arrow RIGHT");
        snoopy.move(Direction.EAST);
        System.out.printf("Current position of player %s is x: %d || y: %d %n",
            snoopy.getName(), snoopy.getX(), snoopy.getY());
    }
}
