import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.*;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe GameBoard (v0.2).
 */
public class GameBoardTest {

    private GameBoard board;


    @BeforeEach
    public void setUp() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            board = new GameBoard();
            board.setVisible(false); // Evita abrir a janela no teste
        });
    }


    @Test
    public void testInitialState() throws Exception {
        assertEquals("Tentativas: 0", getAttemptsLabel().getText());
        assertEquals(0, getPrivateField("attempts", Integer.class));
        assertEquals(0, getPrivateField("pairsFound", Integer.class));
    }

    @Test
    public void testClickOneCardDoesNotCountAsAttempt() throws Exception {
        CardButton btn = getCardButton(0);
        click(btn);

        assertTrue(btn.getCard().isFaceUp());
        assertEquals("Tentativas: 0", getAttemptsLabel().getText());
    }

    @Test
    public void testClickTwoDifferentCardsIncrementsAttempt() throws Exception {
        CardButton btn1 = getCardButton(0);
        CardButton btn2 = getDifferentCardButton(btn1.getCard().getValue());

        click(btn1);
        click(btn2);

        waitForTimer();

        assertEquals(1, getPrivateField("attempts", Integer.class));
        assertEquals("Tentativas: 1", getAttemptsLabel().getText());
    }

    @Test
    public void testRestartGameCreatesNewWindow() {
        // Este teste verifica se o método não lança exceção
        assertDoesNotThrow(() -> board.restartGame());
    }

    // Helpers

    private CardButton getCardButton(int index) throws Exception {
        Field f = GameBoard.class.getDeclaredField("buttons");
        f.setAccessible(true);
        return ((List<CardButton>) f.get(board)).get(index);
    }

    private CardButton getDifferentCardButton(String valueToAvoid) throws Exception {
        for (int i = 0; i < 16; i++) {
            CardButton btn = getCardButton(i);
            if (!btn.getCard().getValue().equals(valueToAvoid)) {
                return btn;
            }
        }
        throw new Exception("Carta diferente não encontrada.");
    }

    private JLabel getAttemptsLabel() throws Exception {
        Field f = GameBoard.class.getDeclaredField("attemptsLabel");
        f.setAccessible(true);
        return (JLabel) f.get(board);
    }

    private <T> T getPrivateField(String name, Class<T> clazz) throws Exception {
        Field f = GameBoard.class.getDeclaredField(name);
        f.setAccessible(true);
        return (T) f.get(board);
    }

    private void click(CardButton button) {
        SwingUtilities.invokeLater(button::doClick);
        try {
            Thread.sleep(100); // Permite o processamento do clique
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void waitForTimer() {
        try {
            Thread.sleep(900); // Aguarda o Timer interno (800ms)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}