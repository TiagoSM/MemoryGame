import org.example.Card;
import org.example.CardButton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe CardButton.
 */
public class CardButtonTest {

    private Card card;
    private CardButton button;

    @BeforeEach
    public void setUp() {
        System.setProperty("java.awt.headless", "true"); // evita problemas gráficos
        card = new Card("X");
        button = new CardButton(card);
    }

    @Test
    public void testInitialTextIsQuestionMark() {
        assertEquals("?", button.getText(), "O botão deve começar com '?'");
    }

    @Test
    public void testGetCardReturnsCorrectCard() {
        assertSame(card, button.getCard(), "O botão deve retornar a carta associada corretamente");
    }

    @Test
    public void testUpdateDisplayShowsCardValueWhenFaceUp() {
        card.flip(); // Vira a carta para cima
        button.updateDisplay();
        assertEquals("X", button.getText(), "O botão deve mostrar o valor da carta quando está virada");
    }

    @Test
    public void testUpdateDisplayShowsQuestionMarkWhenFaceDown() {
        card.flip();     // Vira para cima
        card.flip();     // Vira de volta para baixo
        button.updateDisplay();
        assertEquals("?", button.getText(), "O botão deve mostrar '?' quando a carta está virada para baixo");
    }
}