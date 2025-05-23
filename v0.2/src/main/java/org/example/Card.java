package org.example;
/**
 * A classe Card representa um cartão em um jogo de cartas.
 * Cada cartão tem um valor e um estado que indica se está virado para cima ou para baixo.
 */
public class Card {
    private String value;
    private boolean isFaceUp;

    /**
     * Constrói um novo cartão com o valor especificado.
     *
     * @param value O valor do cartão.
     */
    public Card(String value) {
        this.value = value;
        this.isFaceUp = false;
    }

    /**
     * Retorna o valor do cartão.
     *
     * @return O valor do cartão.
     */
    public String getValue() {
        return value;
    }

    /**
     * Verifica se o cartão está virado para cima.
     *
     * @return true se o cartão estiver virado para cima, caso contrário, false.
     */
    public boolean isFaceUp() {
        return isFaceUp;
    }

    /**
     * Inverte o estado do cartão, mudando de virado para cima para virado para baixo, ou vice-versa.
     */
    public void flip() {
        isFaceUp = !isFaceUp;
    }
}