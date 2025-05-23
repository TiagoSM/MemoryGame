package org.example;

/**
 * A classe Main é o ponto de entrada da aplicação.
 * Ela inicializa a interface gráfica do jogo.
 */
public class Main {

    /**
     * O método main é o ponto de partida da aplicação.
     * Ele utiliza o SwingUtilities para garantir que a criação
     * da interface gráfica ocorra na thread de despacho de eventos.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            // Cria uma nova instância do GameBoard e a torna visível.
            GameBoard game = new GameBoard();
            game.setVisible(true);
        });
    }
}