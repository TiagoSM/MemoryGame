import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.Card;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe Card.
 */
public class CardTest {

    private Card card;

    @BeforeEach
    public void setUp() {
        card = new Card("A");
    }

    @Test
    public void testInitialValue() {
        assertEquals("A", card.getValue(), "O valor da carta deve ser 'A'");
    }

    @Test
    public void testInitialStateIsFaceDown() {
        assertFalse(card.isFaceUp(), "A carta deve começar virada para baixo");
    }

    @Test
    public void testFlipChangesState() {
        card.flip();
        assertTrue(card.isFaceUp(), "A carta deve estar virada para cima após um flip");

        card.flip();
        assertFalse(card.isFaceUp(), "A carta deve voltar a estar virada para baixo após dois flips");
    }
}