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

    public boolean hasUno() {
        return hand.size() == 1;
    }

    public boolean isHandEmpty() {
        return hand.isEmpty();
    }

    public Card getCard(int idx) {
        return hand.get(idx - 1);
    }

    public void receiveCard(Card card) {
        hand.add(card);
    }

    public void playCard(int idx) {
        hand.remove(idx - 1);
    }

    public void showHand() {
        for (int i = 0; i < hand.size(); i++)
            System.out.println((i + 1) + ") " + hand.get(i).getCard());
    }

    public void shoutUno() {
        System.out.println(name + " shouts UNO!");
    }
}
