package org.example;

/**
 * A classe Main é o ponto de entrada da aplicação.
 *
 * Esta classe contém o método main, que é responsável por iniciar a interface gráfica do jogo.
 * O método utiliza o SwingUtilities para garantir que a criação e atualização da interface gráfica
 * sejam realizadas na thread de despacho de eventos do Swing.
 */
public class Main {
    /**
     * O método main é o ponto de partida da aplicação.
     *
     * @param args Argumentos da linha de comando (não utilizados neste exemplo).
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            GameBoard game = new GameBoard();
            game.setVisible(true);
        });
    }
}