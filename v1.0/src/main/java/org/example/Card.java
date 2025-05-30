package org.example;

/**
 * A classe {@code Card} representa uma carta de um baralho.
 * Cada carta possui um valor e um estado que indica se está virada para cima ou para baixo.
 */
public class Card {
    private String value;
    private boolean isFaceUp;

    /**
     * Constrói uma nova carta com o valor especificado.
     *
     * @param value o valor da carta
     */
    public Card(String value) {
        this.value = value;
        this.isFaceUp = false;
    }

    /**
     * Retorna o valor da carta.
     *
     * @return o valor da carta
     */
    public String getValue() {
        return value;
    }

    /**
     * Verifica se a carta está virada para cima.
     *
     * @return {@code true} se a carta estiver virada para cima, {@code false} caso contrário
     */
    public boolean isFaceUp() {
        return isFaceUp;
    }

    /**
     * Inverte o estado da carta, mudando-a de virada para cima para virada para baixo, ou vice-versa.
     */
    public void flip() {
        isFaceUp = !isFaceUp;
    }
}