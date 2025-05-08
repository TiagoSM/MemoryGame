public class Card {
    private String value;
    private boolean isFaceUp;

    public Card(String value) {
        this.value = value;
        this.isFaceUp = false;
    }

    public String getValue() {
        return value;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void flip() {
        isFaceUp = !isFaceUp;
    }
}