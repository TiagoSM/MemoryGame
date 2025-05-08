import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.Timer;


public class GameBoard extends JFrame {
    private List<CardButton> buttons = new ArrayList<>();
    private CardButton firstSelected = null;
    private CardButton secondSelected = null;
    private int attempts = 0;
    private JLabel attemptsLabel;

    public GameBoard() {
        setTitle("Memory Game - v0.1");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(4, 4));
        attemptsLabel = new JLabel("Tentativas: 0");
        add(attemptsLabel, BorderLayout.NORTH);

        List<String> values = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H");
        List<Card> cards = new ArrayList<>();
        for (String v : values) {
            cards.add(new Card(v));
            cards.add(new Card(v));
        }
        Collections.shuffle(cards);

        for (Card card : cards) {
            CardButton btn = new CardButton(card);
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    handleClick(btn);
                }
            });
            buttons.add(btn);
            boardPanel.add(btn);
        }

        add(boardPanel, BorderLayout.CENTER);
    }

    private void handleClick(CardButton btn) {
        if (btn.getCard().isFaceUp() || secondSelected != null) {
            return;
        }

        btn.getCard().flip();
        btn.updateDisplay();

        if (firstSelected == null) {
            firstSelected = btn;
        } else {
            secondSelected = btn;
            attempts++;
            attemptsLabel.setText("Tentativas: " + attempts);

            Timer timer = new Timer(800, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    firstSelected.getCard().flip();
                    secondSelected.getCard().flip();
                    firstSelected.updateDisplay();
                    secondSelected.updateDisplay();
                    firstSelected = null;
                    secondSelected = null;
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
    }
}