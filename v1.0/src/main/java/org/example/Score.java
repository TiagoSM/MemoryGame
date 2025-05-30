package org.example;

/**
 * A classe {@code Score} representa a pontuação de um jogador em um jogo,
 * armazenando o nome do jogador e o número de tentativas que ele fez.
 * Esta classe implementa a interface {@code Comparable<Score>} para permitir
 * a comparação de objetos {@code Score} com base no número de tentativas.
 *
 * <p>Os objetos {@code Score} podem ser usados para classificar jogadores
 * de acordo com seu desempenho, onde um menor número de tentativas indica
 * um desempenho melhor.</p>
 *
 * <p>Exemplo de uso:</p>
 * <pre>
 * Score score1 = new Score("Jogador1", 5);
 * Score score2 = new Score("Jogador2", 3);
 * int comparison = score1.compareTo(score2); // comparação baseada nas tentativas
 * </pre>
 */
public class Score implements Comparable<Score> {
    private String playerName;
    private int attempts;

    /**
     * Constrói um novo objeto {@code Score} com o nome do jogador e o número de tentativas.
     *
     * @param playerName o nome do jogador
     * @param attempts o número de tentativas feitas pelo jogador
     */
    public Score(String playerName, int attempts) {
        this.playerName = playerName;
        this.attempts = attempts;
    }

    /**
     * Retorna o nome do jogador.
     *
     * @return o nome do jogador
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Retorna o número de tentativas feitas pelo jogador.
     *
     * @return o número de tentativas
     */
    public int getAttempts() {
        return attempts;
    }

    /**
     * Compara este objeto {@code Score} com outro objeto {@code Score} com base no número de tentativas.
     *
     * @param other o outro objeto {@code Score} a ser comparado
     * @return um valor negativo se este objeto tiver menos tentativas,
     *         um valor positivo se tiver mais tentativas,
     *         e zero se forem iguais
     */
    @Override
    public int compareTo(Score other) {
        return Integer.compare(this.attempts, other.attempts);
    }
}
