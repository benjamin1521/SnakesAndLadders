package ua.training;

public class Game {
    private Player player;

    public Game(Player player) {
        this.player = player;
    }

    public void movePlayer(Player player, int value) {
        player.setPosition(player.getPosition() + value);
    }

    public static void main(String[] args) {

    }
}
