import org.example.GameBoard;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.assertj.swing.edt.GuiActionRunner;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Test;

/**
 * Classe de teste para a funcionalidade do tabuleiro do jogo.
 * Esta classe estende {@link AssertJSwingJUnitTestCase} para realizar testes de interface gráfica
 * utilizando a biblioteca AssertJ Swing.
 *
 * <p>Os testes garantem que o tabuleiro do jogo se comporte conforme o esperado,
 * incluindo a verificação do rótulo de tentativas iniciais.</p>
 */
public class GameBoardTest extends AssertJSwingJUnitTestCase {

    private FrameFixture window;

    /**
     * Método que é executado uma vez antes de todos os testes na classe.
     * Este método ativa a verificação de violação da EDT (Event Dispatch Thread)
     * para garantir que todas as interações com a interface gráfica sejam feitas
     * na thread correta.
     */
    @BeforeClass
    public static void validateSwingThreading() {
        // Ativa a verificação de violação da EDT
        FailOnThreadViolationRepaintManager.install();
    }

    /**
     * Método chamado antes de cada teste.
     * Este método inicializa a janela do tabuleiro do jogo e a torna visível,
     * permitindo que os testes interajam com a interface gráfica.
     */
    @Override
    protected void onSetUp() {
        GameBoard frame = GuiActionRunner.execute(() -> new GameBoard());
        frame.setVisible(true);
        window = new FrameFixture(robot(), frame);
    }

    /**
     * Método chamado após cada teste.
     * Este método limpa os recursos utilizados pelo FrameFixture, se necessário.
     */
    @After
    public void cleanUpAfterTest() {
        if (window != null) {
            window.cleanUp();
        }
    }

    /**
     * Teste que verifica se o rótulo de tentativas iniciais exibe o texto correto.
     * Este teste assegura que o rótulo mostre "Tentativas: 0" quando o jogo é iniciado.
     */
    @Test
    public void testInitialAttemptsLabel() {
        window.label().requireText("Tentativas: 0");
    }
}