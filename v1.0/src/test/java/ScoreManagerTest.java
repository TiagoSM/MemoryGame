import org.example.Score;
import org.example.ScoreManager;
import org.junit.*;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Classe de teste para o gerenciamento de pontuações utilizando a classe {@link ScoreManager}.
 * Esta classe contém métodos de teste para verificar a funcionalidade de salvar e carregar pontuações.
 */
public class ScoreManagerTest {
    private static final String TEST_FILE = "test_scores.json";
    private ScoreManager scoreManager;

    /**
     * Configura o ambiente de teste antes da execução de cada método de teste.
     * Inicializa uma instância de {@link ScoreManager} com um arquivo de teste.
     */
    @Before
    public void setUp() {
        scoreManager = new ScoreManager(TEST_FILE);
    }

    /**
     * Limpa o ambiente de teste após a execução de cada método de teste.
     * Remove o arquivo de teste criado durante os testes.
     */
    @After
    public void tearDown() {
        new File(TEST_FILE).delete();
    }

    /**
     * Testa a funcionalidade de salvar e carregar uma pontuação.
     * Cria uma nova pontuação, salva-a usando {@link ScoreManager#saveScore(Score)},
     * e em seguida carrega as pontuações para verificar se a pontuação foi salva corretamente.
     *
     * Asserções:
     * - Verifica se o número de pontuações carregadas é igual a 1.
     * - Verifica se o nome do jogador da pontuação carregada é "Alice".
     * - Verifica se o número de tentativas da pontuação carregada é 5.
     */
    @Test
    public void testSaveAndLoadScore() {
        Score score = new Score("Alice", 5);
        scoreManager.saveScore(score);

        List<Score> scores = scoreManager.loadScores();
        assertEquals(1, scores.size());
        assertEquals("Alice", scores.get(0).getPlayerName());
        assertEquals(5, scores.get(0).getAttempts());
    }
}