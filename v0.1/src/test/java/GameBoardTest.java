import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.GameBoard;
import org.example.CardButton;

import javax.swing.*;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe GameBoard.
 */
public class GameBoardTest {

    private GameBoard board;

    @BeforeEach
    public void setUp() {
        board = new GameBoard();
    }

    @Test
    public void testInitialAttemptCount() throws Exception {
        JLabel label = getAttemptsLabel();
        assertEquals("Tentativas: 0", label.getText());
    }

    @Test
    public void testFirstCardClickDoesNotIncreaseAttempt() throws Exception {
        CardButton button = getCardButton(0);
        clickCardButton(button);

        JLabel label = getAttemptsLabel();
        assertEquals("Tentativas: 0", label.getText());
        assertTrue(button.getCard().isFaceUp());
    }

    @Test
    public void testTwoDifferentCardClicksIncreaseAttempt() throws Exception {
        CardButton first = getCardButton(0);
        CardButton second = getDifferentCardButton(first.getCard().getValue());

        clickCardButton(first);
        clickCardButton(second);

        JLabel label = getAttemptsLabel();
        assertEquals("Tentativas: 1", label.getText());
    }

    // Métodos auxiliares

    private CardButton getCardButton(int index) throws Exception {
        Field buttonsField = GameBoard.class.getDeclaredField("buttons");
        buttonsField.setAccessible(true);
        java.util.List<CardButton> buttons = (java.util.List<CardButton>) buttonsField.get(board);
        return buttons.get(index);
    }

    private JLabel getAttemptsLabel() throws Exception {
        Field labelField = GameBoard.class.getDeclaredField("attemptsLabel");
        labelField.setAccessible(true);
        return (JLabel) labelField.get(board);
    }

    private void clickCardButton(CardButton button) {
        SwingUtilities.invokeLater(() -> {
            button.doClick();
        });
        try {
            Thread.sleep(100); // Aguarda a execução da ação no EDT
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private CardButton getDifferentCardButton(String valueToAvoid) throws Exception {
        for (int i = 0; i < 16; i++) {
            CardButton btn = getCardButton(i);
            if (!btn.getCard().getValue().equals(valueToAvoid)) {
                return btn;
            }
        }
        throw new Exception("Nenhuma carta diferente encontrada.");
    }
}