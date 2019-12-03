package ua.training;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private static final int WIN_CELL = 100;
    private static final int START_CELL = 1;
    private Map<Integer, Integer> snakes = new HashMap<Integer, Integer>();
    private Map<Integer, Integer> ladders = new HashMap<Integer, Integer>();

    private Player player;
    private Dice dice;

    public Game(Player player, Dice dice) {
        this.player = player;
        this.dice = dice;
    }

    public void addSnake(Integer start, Integer end) {
        snakes.put(start, end);
    }

    public void addLadder(Integer start, Integer end) {
        ladders.put(start, end);
    }

    public void movePlayer(Player player, int value) {
        int position = player.getPosition() + value;

        if (position <= WIN_CELL) {
            player.setPosition(position);
        }
        if (snakes.get(position) != null) {
            System.out.println("eaten by snake");
            player.setPosition(snakes.get(position));
        }
        if (ladders.get(position) != null) {
            System.out.println("lifted by ladder");
            player.setPosition(ladders.get(position));
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
        new Game(new Player(0, START_CELL), new Dice()).startGame();
    }
}
