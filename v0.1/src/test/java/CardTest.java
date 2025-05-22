import org.example.Card;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe Card.
 */
public class CardTest{

    @Test
    public void testCardInitialState() {
        Card card = new Card("A");
        assertEquals("A", card.getValue());
        assertFalse(card.isFaceUp(), "A carta deve iniciar virada para baixo");
    }

    @Test
    public void testFlip() {
        Card card = new Card("B");
        card.flip();
        assertTrue(card.isFaceUp());
        card.flip();
        assertFalse(card.isFaceUp());
    }
}