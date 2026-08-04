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
        deck.add(new NormalCard("0", "RED"));
        deck.add(new NormalCard("0", "GREEN"));
        deck.add(new NormalCard("0", "YELLOW"));
        deck.add(new NormalCard("0", "BLUE"));

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 9; j++) {
                deck.add(new NormalCard(String.valueOf(j + 1), "RED"));
                deck.add(new NormalCard(String.valueOf(j + 1), "GREEN"));
                deck.add(new NormalCard(String.valueOf(j + 1), "YELLOW"));
                deck.add(new NormalCard(String.valueOf(j + 1), "BLUE"));
            }

            deck.add(new ActionCard("S", "RED"));
            deck.add(new ActionCard("S", "GREEN"));
            deck.add(new ActionCard("S", "YELLOW"));
            deck.add(new ActionCard("S", "BLUE"));

            deck.add(new ActionCard("R", "RED"));
            deck.add(new ActionCard("R", "GREEN"));
            deck.add(new ActionCard("R", "YELLOW"));
            deck.add(new ActionCard("R", "BLUE"));

            deck.add(new ActionCard("+2", "RED"));
            deck.add(new ActionCard("+2", "GREEN"));
            deck.add(new ActionCard("+2", "YELLOW"));
            deck.add(new ActionCard("+2", "BLUE"));
        }

        for (int i = 0; i < 4; i++) {
            deck.add(new WildCard("CC"));
            deck.add(new WildCard("+4"));
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
