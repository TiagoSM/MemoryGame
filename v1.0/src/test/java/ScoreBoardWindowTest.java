import org.example.Score;
import org.example.ScoreBoardWindow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe de teste para a janela de placares (ScoreBoardWindow).
 *
 * Esta classe contém métodos de teste que verificam a correta inicialização
 * da janela de placares, incluindo a verificação do título da janela,
 * suas dimensões e o conteúdo exibido na área de texto.
 */
public class ScoreBoardWindowTest {
    private List<Score> scores;

    /**
     * Configura o ambiente de teste antes de cada método de teste.
     * Inicializa uma lista de placares com três jogadores e suas respectivas pontuações.
     */
    @BeforeEach
    public void setUp() {
        scores = new ArrayList<>();
        scores.add(new Score("Jogador1", 3));
        scores.add(new Score("Jogador2", 5));
        scores.add(new Score("Jogador3", 2));
    }

    /**
     * Testa a inicialização da janela de placares.
     *
     * Este método verifica se:
     * - O título da janela é "Melhores Placares".
     * - As dimensões da janela são 300x300 pixels.
     * - A JTextArea contém os placares corretos formatados.
     */
    @Test
    public void testScoreBoardWindowInitialization() {
        ScoreBoardWindow scoreBoardWindow = new ScoreBoardWindow(scores);

        // Verifica se o título da janela está correto
        assertEquals("Melhores Placares", scoreBoardWindow.getTitle());

        // Verifica se o tamanho da janela está correto
        assertEquals(300, scoreBoardWindow.getWidth());
        assertEquals(300, scoreBoardWindow.getHeight());

        // Verifica se a JTextArea contém os placares corretos
        JTextArea textArea = (JTextArea) ((JScrollPane) scoreBoardWindow.getContentPane().getComponent(0)).getViewport().getView();
        String expectedText = "1. Jogador1 - 3 tentativas\n" +
                "2. Jogador2 - 5 tentativas\n" +
                "3. Jogador3 - 2 tentativas\n";
        assertEquals(expectedText, textArea.getText());
    }
}