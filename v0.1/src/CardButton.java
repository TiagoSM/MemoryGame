import javax.swing.JButton;

public class CardButton extends JButton {
    private Card card;

    public CardButton(Card card) {
        this.card = card;
        this.setText("?");
    }

    public Card getCard() {
        return card;
    }

    public void updateDisplay() {
        if (card.isFaceUp()) {
            this.setText(card.getValue());
        } else {
            this.setText("?");
        }
    }
}