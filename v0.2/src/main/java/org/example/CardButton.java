package org.example;
import javax.swing.JButton;

/**
 * A classe {@code CardButton} representa um botão que exibe uma carta em um jogo de cartas.
 * Este botão pode mostrar o valor da carta quando ela está virada para cima ou um caractere de
 * interrogação quando está virada para baixo.
 */
public class CardButton extends JButton {
    private Card card;

    /**
     * Construtor da classe {@code CardButton}.
     *
     * @param card a carta associada a este botão
     */
    public CardButton(Card card) {
        this.card = card;
        this.setText("?");
    }

    /**
     * Retorna a carta associada a este botão.
     *
     * @return a carta associada
     */
    public Card getCard() {
        return card;
    }

    /**
     * Atualiza a exibição do botão com base no estado da carta.
     * Se a carta estiver virada para cima, o texto do botão será atualizado
     * para mostrar o valor da carta. Caso contrário, o texto será um caractere
     * de interrogação.
     */
    public void updateDisplay() {
        if (card.isFaceUp()) {
            this.setText(card.getValue());
        } else {
            this.setText("?");
        }
    }
}