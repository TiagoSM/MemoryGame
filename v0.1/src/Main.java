public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            GameBoard game = new GameBoard();
            game.setVisible(true);
        });
    }
}