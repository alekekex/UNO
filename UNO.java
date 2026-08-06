import java.util.ArrayList;
import java.util.List;

public class UNO {
    private Deck deck;
    private List<Card> pile;
    private List<Player> players;
    private int playerIdx;
    private int direction;
    private boolean isGameOver;

    public UNO() {
        this.deck = new Deck();
        this.pile = new ArrayList<>();
        this.players = new ArrayList<>();
        this.playerIdx = 0;
        this.direction = 1;
        this.isGameOver = false;
    }

    public void initializePlayers(List<String> names) {
        for (String name : names)
            players.add(new Player(name));
    }

    public void playGame() {
        for (int i = 0; i < 7; i++) {
            for (Player player : players) {
                Card card = deck.drawCard();
                player.receiveCard(card);
            }
        }

        boolean isValid = false;

        while (!isValid) {
            Card startCard = deck.drawCard();

            if (startCard instanceof NormalCard) {
                isValid = true;
                pile.add(startCard);
            } else deck.addCardToBottom(startCard);
        }

        System.out.println("Starting Card: " + pile.get(pile.size() - 1).getCard());
        System.out.println();

        while (!isGameOver) {
            Player currPlayer = players.get(playerIdx);

            System.out.println(currPlayer.getName() + "\'s hand:");
            currPlayer.showHand();
            System.out.println();

            boolean isTurnOver = false;

            while (!isTurnOver) {
                System.out.println(currPlayer.getName() + ", what is your move?");
                System.out.println("1) Play Card");
                System.out.println("2) Draw Card");
                int choice = Input.getIntInput("Enter your choice: ", 1, 2);

                switch (choice) {
                    case 1:
                        int cardIdx = Input.getIntInput("Select card from hand: ",
                                1, currPlayer.getHandSize());
                        Card chosenCard = currPlayer.getCard(cardIdx);

                        if (chosenCard.canPlayOn(pile.get(pile.size() - 1))) {
                            isTurnOver = true;
                            currPlayer.playCard(cardIdx);
                            pile.add(chosenCard);

                            System.out.println();
                            System.out.println("Top Card: " + pile.get(pile.size() - 1).getCard());

                            if (pile.get(pile.size() - 1) instanceof WildCard &&
                                    !pile.get(pile.size() - 1).getColor().equals("NONE"))
                                System.out.println("Active Color: " +
                                        ((WildCard) pile.get(pile.size() - 1)).getActiveColor());

                            chosenCard.applyCardEffect(this);
                        } else System.out.println("Invalid option! Card is not valid.");

                        System.out.println();
                        break;
                    case 2:
                        Card drawnCard = deck.drawCard();
                        currPlayer.receiveCard(drawnCard);

                        System.out.println();
                        System.out.println("Drawn Card: " + drawnCard.getCard());
                        System.out.println();

                        System.out.println(currPlayer.getName() + ", what do you want to do?");
                        System.out.println("1) Play Drawn Card");
                        System.out.println("2) Skip Turn");
                        int choice2 = Input.getIntInput("Enter your choice: ", 1, 2);

                        switch (choice2) {
                            case 1:
                                Card chosenDrawnCard = currPlayer.getCard(currPlayer.getHandSize());

                                if (chosenDrawnCard.canPlayOn(pile.get(pile.size() - 1))) {
                                    currPlayer.playCard(currPlayer.getHandSize());
                                    pile.add(chosenDrawnCard);

                                    System.out.println();
                                    System.out.println("Top Card: " + pile.get(pile.size() - 1).getCard());

                                    if (pile.get(pile.size() - 1) instanceof WildCard &&
                                            !pile.get(pile.size() - 1).getColor().equals("NONE"))
                                        System.out.println("Active Color: " +
                                                ((WildCard) pile.get(pile.size() - 1)).getActiveColor());

                                    chosenDrawnCard.applyCardEffect(this);
                                } else {
                                    System.out.println("Invalid option! Card is not valid.");
                                    System.out.println("Turn skipped!");
                                    System.out.println();
                                    System.out.println("Top Card: " + pile.get(pile.size() - 1).getCard());

                                    if (pile.get(pile.size() - 1) instanceof WildCard &&
                                            !pile.get(pile.size() - 1).getColor().equals("NONE"))
                                        System.out.println("Active Color: " +
                                                ((WildCard) pile.get(pile.size() - 1)).getActiveColor());
                                }

                                break;
                            case 2:
                                System.out.println("Turn skipped!");
                                System.out.println();
                                System.out.println("Top Card: " + pile.get(pile.size() - 1).getCard());

                                if (pile.get(pile.size() - 1) instanceof WildCard &&
                                        !pile.get(pile.size() - 1).getColor().equals("NONE"))
                                    System.out.println("Active Color: " +
                                            ((WildCard) pile.get(pile.size() - 1)).getActiveColor());
                                break;
                        }

                        isTurnOver = true;
                        System.out.println();
                        break;
                }
            }

            if (currPlayer.hasUno()) {
                currPlayer.shoutUno();
                System.out.println();
            }

            if (currPlayer.isHandEmpty())
                isGameOver = true;
            else advanceTurn();
        }

        if (isGameOver) {
            System.out.println(players.get(playerIdx).getName() + " is the winner!");
            System.out.println();
        }
    }

    public void advanceTurn() {
        playerIdx = (playerIdx + direction + players.size()) % players.size();
    }

    public void reverseDirection() {
        if (players.size() == 2)
            advanceTurn();
        else direction = -direction;
    }

    public void skipNextPlayer() {
        advanceTurn();
    }

    public void drawTwo() {
        int nextPlayerIdx = (playerIdx + direction + players.size()) % players.size();
        advanceTurn();

        for (int i = 0; i < 2; i++)
            players.get(nextPlayerIdx).receiveCard(deck.drawCard());
    }

    public void changeColor(WildCard card) {
        System.out.println("1) Red");
        System.out.println("2) Green");
        System.out.println("3) Yellow");
        System.out.println("4) Blue");
        int choice = Input.getIntInput("Choose a color: ", 1, 4);

        switch (choice) {
            case 1:
                card.setActiveColor("RED");
                break;
            case 2:
                card.setActiveColor("GREEN");
                break;
            case 3:
                card.setActiveColor("YELLOW");
                break;
            case 4:
                card.setActiveColor("BLUE");
                break;
        }

        System.out.println("Active Color: " + card.getActiveColor());
    }

    public void drawFour(WildCard card) {
        int nextPlayerIdx = (playerIdx + direction + players.size()) % players.size();
        changeColor(card);
        advanceTurn();

        for (int i = 0; i < 4; i++)
            players.get(nextPlayerIdx).receiveCard(deck.drawCard());
    }
}
