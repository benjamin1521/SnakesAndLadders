package ua.training;

import java.util.Scanner;

public class Game {
    private static final int WIN_CELL = 100;
    private static final int START_CELL = 1;
    private Player player;
    private Dice dice = new Dice();

    public Game(Player player) {
        this.player = player;
    }

    public void movePlayer(Player player, int value) {
        int position = player.getPosition() + value;

        if (position <= WIN_CELL) {
            player.setPosition(position);
        }
    }

    public boolean isWin(int position) {
        return WIN_CELL == position;
    }

    public void startGame() {
        Scanner s = new Scanner(System.in);
        String str;
        int diceValue;

        do {
            System.out.println("Press 1 to roll Dice");
            str = s.next();

            diceValue = dice.roll();
            System.out.println("You rolled " + diceValue);

            movePlayer(player, diceValue);
            System.out.println("Position: " + player.getPosition() + "\n");

            if (isWin(player.getPosition())) {
                System.out.println("Player " + player.getId() + " wins!");
                return;
            }

        } while ("1".equals(str));
    }

    public static void main(String[] args) {
        new Game(new Player(0, START_CELL)).startGame();
    }
}
