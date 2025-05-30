package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * A classe ScoreBoardWindow representa uma janela que exibe os melhores placares de um jogo.
 * Esta janela é uma extensão de JFrame e apresenta uma lista de pontuações em um JTextArea.
 *
 * <p>A janela é configurada com um título, um tamanho fixo e um layout de BorderLayout.
 * O JTextArea é utilizado para mostrar os nomes dos jogadores e o número de tentativas
 * que cada um fez, ordenados por classificação.</p>
 *
 * <p>O construtor da classe recebe uma lista de objetos Score, que contém informações
 * sobre os jogadores e suas respectivas tentativas. A lista é percorrida e cada placar
 * é adicionado ao JTextArea com a sua classificação correspondente.</p>
 *
 */
public class ScoreBoardWindow extends JFrame {
    public ScoreBoardWindow(List<Score> scores) {
        setTitle("Melhores Placares");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        int rank = 1;
        for (Score score : scores) {
            textArea.append(rank + ". " + score.getPlayerName() + " - " + score.getAttempts() + " tentativas\n");
            rank++;
        }

        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }
}