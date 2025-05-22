package org.example;

/**
 * A classe Main é o ponto de entrada da aplicação.
 * Ela inicializa a interface gráfica do jogo ao invocar o método
 * {@link javax.swing.SwingUtilities#invokeLater(Runnable)} para garantir
 * que a criação da interface gráfica ocorra na thread de despacho de eventos.
 */
public class Main {
    /**
     * O método main é o ponto de partida da aplicação.
     * Ele cria uma instância de {@link GameBoard} e a torna visível.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            GameBoard game = new GameBoard();
            game.setVisible(true);
        });
    }
}