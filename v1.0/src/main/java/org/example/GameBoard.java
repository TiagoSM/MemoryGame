package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.Timer;

/**
 * A classe GameBoard representa a interface gráfica do jogo da memória.
 * Ela estende JFrame e contém a lógica para gerenciar o estado do jogo,
 * incluindo a seleção de cartas, contagem de tentativas e exibição de pontuações.
 */
public class GameBoard extends JFrame {
    private List<CardButton> buttons = new ArrayList<>();
    private CardButton firstSelected = null;
    private CardButton secondSelected = null;
    private int attempts = 0;
    private int pairsFound = 0;
    private JLabel attemptsLabel;

    /**
     * Construtor da classe GameBoard. Inicializa a janela do jogo,
     * configura o layout, cria os botões de cartas e adiciona
     * componentes à interface.
     */
    public GameBoard() {
        setTitle("Memory Game - v1.0");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(4, 4));
        attemptsLabel = new JLabel("Tentativas: 0");
        add(attemptsLabel, BorderLayout.NORTH);

        // Botão de reiniciar
        JButton resetButton = new JButton("Reiniciar Jogo");
        resetButton.addActionListener(e -> restartGame());
        add(resetButton, BorderLayout.SOUTH);

        // Criar pares de cartas
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

    /**
     * Trata o clique em um botão de carta. Verifica se a carta já está virada
     * ou se já há duas cartas selecionadas. Se não, vira a carta e verifica
     * se é a primeira ou a segunda carta selecionada.
     *
     * @param btn O botão de carta que foi clicado.
     */
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
                    checkMatch();
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    /**
     * Verifica se as duas cartas selecionadas correspondem. Se corresponderem,
     * incrementa o contador de pares encontrados. Se não corresponderem,
     * vira as cartas de volta.
     */
    private void checkMatch() {
        if (firstSelected.getCard().getValue().equals(secondSelected.getCard().getValue())) {
            pairsFound++;
            if (pairsFound == 8) {
                String name = JOptionPane.showInputDialog(this, "Digite seu nome:");
                if (name != null && !name.trim().isEmpty()) {
                    ScoreManager.saveScore(new Score(name.trim(), attempts));
                }
                showScoreBoard();
            }
        } else {
            firstSelected.getCard().flip();
            secondSelected.getCard().flip();
            firstSelected.updateDisplay();
            secondSelected.updateDisplay();
        }

        firstSelected = null;
        secondSelected = null;
    }

    /**
     * Exibe a tabela de pontuações com as pontuações salvas.
     */
    private void showScoreBoard() {
        List<Score> scores = ScoreManager.loadScores();
        ScoreBoardWindow scoreboard = new ScoreBoardWindow(scores);
        scoreboard.setVisible(true);
    }

    /**
     * Reinicia o jogo, fechando a janela atual e abrindo uma nova instância
     * do GameBoard.
     */
    private void restartGame() {
        this.dispose(); // Fecha a janela atual
        new GameBoard().setVisible(true); // Abre uma nova
    }
}