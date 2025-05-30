import org.example.Card;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe Card.
 */
public class CardTest {

    @Test
    public void testConstructorInitialState() {
        Card card = new Card("A");
        assertEquals("A", card.getValue(), "O valor da carta deve ser 'A'");
        assertFalse(card.isFaceUp(), "A carta deve iniciar virada para baixo");
    }

    @Test
    public void testFlipOnce() {
        Card card = new Card("B");
        card.flip();
        assertTrue(card.isFaceUp(), "A carta deve estar virada para cima após um flip");
    }

    @Test
    public void testFlipTwice() {
        Card card = new Card("C");
        card.flip();  // vira para cima
        card.flip();  // vira para baixo
        assertFalse(card.isFaceUp(), "A carta deve estar virada para baixo após dois flips");
    }
}