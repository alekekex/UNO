import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHandSize() {
        return hand.size();
    }

    public boolean isHandEmpty() {
        return hand.isEmpty();
    }

    public void receiveCard(Card card) {
        hand.add(card);
    }

    public Card playCard(int idx) {
        Card card = hand.get(idx - 1);
        hand.remove(idx - 1);

        return card;
    }

    public void displayHand() {
        if (isHandEmpty())
            System.out.println("[Empty]");
        else {
            for (int i = 0; i < hand.size(); i++)
                System.out.println((i + 1) + ") " + hand.get(i).getCard());
        }
    }
}
