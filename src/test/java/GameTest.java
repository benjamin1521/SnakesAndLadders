import org.junit.Before;
import org.junit.Test;
import ua.training.Game;
import ua.training.Player;

import static org.junit.Assert.assertEquals;

public class GameTest {
    private Game game;
    private Player player = new Player(0, 1);

    @Before
    public void init() {
        game = new Game(player);
    }

    @Test
    public void shouldBeOnCell1_whenGameStarted() {
        assertEquals(player.getPosition(), 1);
    }

    @Test
    public void shouldBeOnCell4_whenMoveFrom1By3() {
        game.movePlayer(player, 3);

        assertEquals(player.getPosition(),4);
    }

    @Test
    public void shouldBeOnCell8_whenMoveFrom1By3AndBy4(){
        game.movePlayer(player,3);
        game.movePlayer(player,4);

        assertEquals(player.getPosition(),8);
    }
}
