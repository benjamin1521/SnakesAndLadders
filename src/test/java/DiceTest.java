import org.junit.Test;
import ua.training.Dice;

import static org.junit.Assert.assertTrue;

public class DiceTest {
    private Dice dice = new Dice();

    @Test
    public void shouldReturnIntBetween1And6() {
        int expected = dice.roll();

        assertTrue(expected > 0 && expected <= 6);
    }
}
