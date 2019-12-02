import org.junit.Before;
import org.junit.Test;
import ua.training.Dice;
import ua.training.Game;
import ua.training.Player;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    private Game game;
    private Player player = new Player(0, 1);
    private Dice dice = mock(Dice.class);

    @Before
    public void init() {
        game = new Game(player);
    }

    @Test
    public void shouldBeOnCell1_whenGameStarted() {
        assertEquals(1, player.getPosition());
    }

    @Test
    public void shouldBeOnCell4_whenMoveFrom1By3() {
        game.movePlayer(player, 3);

        assertEquals(4, player.getPosition());
    }

    @Test
    public void shouldBeOnCell8_whenMoveFrom1By3AndBy4() {
        game.movePlayer(player, 3);
        game.movePlayer(player, 4);

        assertEquals(8, player.getPosition());
    }

    @Test
    public void shouldBeOnCell5_whenMoveFrom1ByRolled4() {
        when(dice.roll()).thenReturn(4);

        game.movePlayer(player, dice.roll());

        assertEquals(4, dice.roll());
        assertEquals(5, player.getPosition());
    }

    @Test
    public void shouldWinGame_whenMoveFrom97By3() {
        player.setPosition(97);
        game.movePlayer(player, 3);

        assertEquals(100, player.getPosition());
        assertTrue(game.isWin(player.getPosition()));
    }

    @Test
    public void shouldStay_whenMoveFrom97By4(){
        player.setPosition(97);
        game.movePlayer(player,4);

        assertEquals(97,player.getPosition());
        assertFalse(game.isWin(player.getPosition()));
    }
}
