import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
    }

    public void addCard(Card card) {
        deck.add(card);
    }

    public void removeCard(Card card) {
        deck.remove(card);
    }

    public Card drawCard() {
        Card card = deck.get(deck.size() - 1);
        deck.remove(deck.size() - 1);

        return card;
    }

    public int getDeckSize() {
        return deck.size();
    }

    public boolean isDeckEmpty() {
        return deck.isEmpty();
    }

    public void shuffleDeck() {
        Random rand = new Random();

        for (int i = 0; i < deck.size(); i++) {
            int randIdx = rand.nextInt(deck.size() - i) + i;

            Card temp = deck.get(i);
            deck.set(i, deck.get(randIdx));
            deck.set(randIdx, temp);
        }
    }

    public void displayDeck() {
        if (isDeckEmpty())
            System.out.println("[Empty]");
        else {
            for (Card card : deck)
                System.out.print(card.getCard() + " ");
        }
    }
}
