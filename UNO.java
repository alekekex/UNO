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
        for (int i = 0; i < 2; i++) { // temp, og is 7
            for (Player player : players) {
                Card card = deck.drawCard();
                player.receiveCard(card);
            }
        }

        pile.add(deck.drawCard());

        while (!isGameOver) {
            Player currPlayer = players.get(playerIdx);
            Card topCard = pile.get(pile.size() - 1);
            System.out.println("Top Card: " + topCard.getCard());
            System.out.println();

            System.out.println(currPlayer.getName() + "\'s hand:");
            currPlayer.showHand();
            System.out.println();

            System.out.println(currPlayer.getName() + ", what is your move?");
            System.out.println("1) Play Card");
            System.out.println("2) Draw Card");
            int choice = Input.getIntInput(sc, "Enter your choice: ", 1, 2);

            switch (choice) {
                case 1:
                    int cardIdx = Input.getIntInput(sc, "Select card from hand: ",
                            1, currPlayer.getHandSize());
                    Card chosenCard = currPlayer.playCard(cardIdx);
                    // needs validation if card can be played
                    pile.add(chosenCard);
                    System.out.println();
                    break;
                case 2:
                    Card drawnCard = deck.drawCard();
                    currPlayer.receiveCard(drawnCard);
                    System.out.println();
                    System.out.println("Drawn Card: " + drawnCard.getCard());
                    System.out.println();

                    System.out.println(currPlayer.getName() + ", what do you want to do?");
                    System.out.println("1) Play Card");
                    System.out.println("2) Skip Turn");
                    int choice2 = Input.getIntInput(sc, "Enter your choice: ", 1, 2);

                    switch (choice2) {
                        case 1:
                            Card chosenDrawnCard = currPlayer.playCard(currPlayer.getHandSize());
                            // needs validation if card can be played
                            pile.add(chosenDrawnCard);
                            break;
                        case 2:
                            System.out.println("Turn skipped!");
                            break;
                    }

                    System.out.println();
                    break;
            }

            if (currPlayer.isHandEmpty())
                isGameOver = true;
            else playerIdx = (playerIdx + 1) % players.size();
        }

        if (isGameOver) {
            System.out.println(players.get(playerIdx).getName() + " is the winner!");
            System.out.println();
        }
    }
}
