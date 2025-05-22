package org.example;

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
        card = new Card("X");
        button = new CardButton(card);
    }

    @Test
    public void testInitialState() {
        // Ao iniciar, a carta está virada para baixo e o botão deve exibir "?"
        assertEquals("?", button.getText());
        assertFalse(card.isFaceUp());
    }

    @Test
    public void testUpdateDisplayWhenFaceUp() {
        card.flip(); // vira a carta para cima
        button.updateDisplay();
        assertEquals("X", button.getText());
    }

    @Test
    public void testUpdateDisplayWhenFaceDown() {
        card.flip(); // vira para cima
        card.flip(); // vira novamente para baixo
        button.updateDisplay();
        assertEquals("?", button.getText());
    }

    @Test
    public void testGetCard() {
        assertEquals(card, button.getCard());
    }
}