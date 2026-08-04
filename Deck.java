import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
        initializeDeck();
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

    public void initializeDeck() {
        deck.add(new Card("NORMAL", "0", "RED"));
        deck.add(new Card("NORMAL", "0", "GREEN"));
        deck.add(new Card("NORMAL", "0", "YELLOW"));
        deck.add(new Card("NORMAL", "0", "BLUE"));

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 9; j++) {
                deck.add(new Card("NORMAL", String.valueOf(j + 1), "RED"));
                deck.add(new Card("NORMAL", String.valueOf(j + 1), "GREEN"));
                deck.add(new Card("NORMAL", String.valueOf(j + 1), "YELLOW"));
                deck.add(new Card("NORMAL", String.valueOf(j + 1), "BLUE"));
            }

            deck.add(new Card("ACTION", "S", "RED"));
            deck.add(new Card("ACTION", "S", "GREEN"));
            deck.add(new Card("ACTION", "S", "YELLOW"));
            deck.add(new Card("ACTION", "S", "BLUE"));

            deck.add(new Card("ACTION", "R", "RED"));
            deck.add(new Card("ACTION", "R", "GREEN"));
            deck.add(new Card("ACTION", "R", "YELLOW"));
            deck.add(new Card("ACTION", "R", "BLUE"));

            deck.add(new Card("ACTION", "+2", "RED"));
            deck.add(new Card("ACTION", "+2", "GREEN"));
            deck.add(new Card("ACTION", "+2", "YELLOW"));
            deck.add(new Card("ACTION", "+2", "BLUE"));
        }

        for (int i = 0; i < 4; i++) {
            deck.add(new Card("WILD", "CC", "GRAY"));
            deck.add(new Card("WILD", "+4", "GRAY"));
        }
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
                System.out.println(card.getCard());
        }
    }
}
