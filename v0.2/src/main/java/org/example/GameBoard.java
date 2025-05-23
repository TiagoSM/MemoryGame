package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.Timer;

/**
 * Classe que representa o tabuleiro do jogo da memória.
 * Esta classe estende JFrame e gerencia a lógica do jogo, incluindo a criação de cartas,
 * a manipulação de cliques e a verificação de pares.
 */
public class GameBoard extends JFrame {
    private List<CardButton> buttons = new ArrayList<>();
    private CardButton firstSelected = null;
    private CardButton secondSelected = null;
    private int attempts = 0;
    private int pairsFound = 0;
    private JLabel attemptsLabel;

    /**
     * Construtor da classe GameBoard.
     * Inicializa a interface gráfica do jogo, cria os botões das cartas,
     * e configura o painel do tabuleiro.
     */
    public GameBoard() {
        setTitle("Memory Game - v0.2");
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
     * Manipula o clique em um botão de carta.
     * Verifica se a carta já está virada ou se já há duas cartas selecionadas.
     * Se não, vira a carta e verifica se é a primeira ou segunda seleção.
     *
     * @param btn O botão da carta que foi clicado.
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
     * Verifica se as duas cartas selecionadas formam um par.
     * Se forem iguais, incrementa o contador de pares encontrados.
     * Se não forem, desvira as cartas após um breve atraso.
     */
    private void checkMatch() {
        if (firstSelected.getCard().getValue().equals(secondSelected.getCard().getValue())) {
            // Deixar as cartas viradas (não fazer nada)
            pairsFound++;
            if (pairsFound == 8) {
                JOptionPane.showMessageDialog(this,
                        "Parabéns! Você terminou o jogo com " + attempts + " tentativas.",
                        "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // Desvirar cartas
            firstSelected.getCard().flip();
            secondSelected.getCard().flip();
            firstSelected.updateDisplay();
            secondSelected.updateDisplay();
        }

        firstSelected = null;
        secondSelected = null;
    }

    /**
     * Reinicia o jogo, fechando a janela atual e abrindo uma nova instância do GameBoard.
     */
    public void restartGame() {
        this.dispose(); // Fecha a janela atual
        new GameBoard().setVisible(true); // Abre uma nova
    }
}