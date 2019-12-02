package ua.training;

public class Game {
    private static final int WIN_CELL = 100;
    private Player player;

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

    public static void main(String[] args) {

    }
}
