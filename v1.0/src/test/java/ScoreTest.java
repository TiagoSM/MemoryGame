import org.example.Score;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste para a classe Score.
 *
 * Esta classe contém métodos de teste que verificam o comportamento da classe Score,
 * incluindo a construção de objetos, acesso a atributos e comparação entre instâncias
 * com base no número de tentativas.
 */
public class ScoreTest {

    /**
     * Testa o construtor e os métodos getters da classe Score.
     *
     * Este teste verifica se o nome do jogador e o número de tentativas
     * são corretamente atribuídos e retornados pelo objeto Score.
     */
    @Test
    public void testConstructorAndGetters() {
        Score score = new Score("Jogador1", 5);

        assertEquals("Jogador1", score.getPlayerName(), "O nome do jogador deve ser 'Jogador1'");
        assertEquals(5, score.getAttempts(), "O número de tentativas deve ser 5");
    }

    /**
     * Testa a comparação entre duas instâncias de Score quando a primeira
     * tem menos tentativas que a segunda.
     *
     * Este teste verifica se o método compareTo retorna um valor negativo
     * quando o primeiro Score tem menos tentativas que o segundo.
     */
    @Test
    public void testCompareToLessAttempts() {
        Score score1 = new Score("Jogador1", 3);
        Score score2 = new Score("Jogador2", 5);

        assertTrue(score1.compareTo(score2) < 0, "score1 deve ter menos tentativas que score2");
    }

    /**
     * Testa a comparação entre duas instâncias de Score quando a primeira
     * tem mais tentativas que a segunda.
     *
     * Este teste verifica se o método compareTo retorna um valor positivo
     * quando o primeiro Score tem mais tentativas que o segundo.
     */
    @Test
    public void testCompareToMoreAttempts() {
        Score score1 = new Score("Jogador1", 7);
        Score score2 = new Score("Jogador2", 5);

        assertTrue(score1.compareTo(score2) > 0, "score1 deve ter mais tentativas que score2");
    }

    /**
     * Testa a comparação entre duas instâncias de Score quando ambas
     * têm o mesmo número de tentativas.
     *
     * Este teste verifica se o método compareTo retorna zero quando
     * ambos os Scores têm o mesmo número de tentativas.
     */
    @Test
    public void testCompareToEqualAttempts() {
        Score score1 = new Score("Jogador1", 5);
        Score score2 = new Score("Jogador2", 5);

        assertEquals(0, score1.compareTo(score2), "score1 e score2 devem ter o mesmo número de tentativas");
    }
}