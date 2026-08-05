import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UNO {
    private Deck deck;
    private List<Card> pile;
    private List<Player> players;
    private int playerIdx;
    private boolean isGameOver;

    public UNO() {
        this.deck = new Deck();
        this.pile = new ArrayList<>();
        this.players = new ArrayList<>();
        this.playerIdx = 0;
        this.isGameOver = false;
    }

    public void initializePlayers(List<String> names) {
        for (String name : names)
            players.add(new Player(name));
    }

    public void playGame(Scanner sc) {
        System.out.println("Game implementation will be made soon");
    }
}
