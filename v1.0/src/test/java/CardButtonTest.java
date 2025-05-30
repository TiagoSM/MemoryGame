import org.example.Card;
import org.example.CardButton;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe CardButton.
 */
public class CardButtonTest {

    @Test
    public void testConstructorInitialState() {
        Card card = new Card("X");
        CardButton button = new CardButton(card);

        assertNotNull(button.getCard(), "O botão deve conter uma carta.");
        assertEquals("?", button.getText(), "O texto inicial do botão deve ser '?'.");
    }

    @Test
    public void testUpdateDisplayWhenCardFaceDown() {
        Card card = new Card("A");
        CardButton button = new CardButton(card);
        button.updateDisplay();

        assertEquals("?", button.getText(), "O botão deve exibir '?' quando a carta estiver virada para baixo.");
    }

    @Test
    public void testUpdateDisplayWhenCardFaceUp() {
        Card card = new Card("B");
        card.flip(); // vira para cima
        CardButton button = new CardButton(card);
        button.updateDisplay();

        assertEquals("B", button.getText(), "O botão deve exibir o valor da carta quando ela estiver virada para cima.");
    }
}