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
        dealCards();
        displayStartingCard();

        while (!isGameOver) {
            Player currPlayer = players.get(playerIdx);

            displayPlayerHand(currPlayer);
            playTurn(currPlayer);

            checkIfUno(currPlayer);
            checkIfGameOver(currPlayer);

            if (!isGameOver)
                advanceTurn();
        }

        displayWinner();
    }

    public void dealCards() {
        for (int i = 0; i < 7; i++) {
            for (Player player : players) {
                Card card = deck.drawCard();
                player.receiveCard(card);
            }
        }
    }

    public void displayStartingCard() {
        Card card = deck.drawCard();

        while (!(card instanceof NormalCard)) {
            deck.addCardToBottom(card);
            card = deck.drawCard();
        }

        pile.add(card);

        System.out.println("Starting Card: " + card.getCard());
        System.out.println();
    }

    public void displayPlayerHand(Player player) {
        System.out.println(player.getName() + "\'s hand:");
        player.showHand();
        System.out.println();
    }

    public Card getTopCard() {
        return pile.get(pile.size() - 1);
    }

    public void playTurn(Player player) {
        boolean isTurnOver = false;

        while (!isTurnOver) {
            System.out.println(player.getName() + ", what is your move?");
            System.out.println("1) Play Card");
            System.out.println("2) Draw Card");
            int choice = Input.getIntInput("Enter your choice: ", 1, 2);

            switch (choice) {
                case 1:
                    isTurnOver = handlePlayCard(player);
                    break;
                case 2:
                    isTurnOver = handleDrawCard(player);
                    break;
            }
        }
    }

    public boolean handlePlayCard(Player player) {
        int cardIdx = Input.getIntInput("Select card from hand: ", 1, player.getHandSize());
        Card card = player.getCard(cardIdx);
        boolean isOver = false;

        if (card.canPlayOn(getTopCard())) {
            isOver = true;
            player.playCard(cardIdx);
            pile.add(card);

            System.out.println();
            displayTopCard();

            card.applyCardEffect(this);
        } else System.out.println("Invalid option! Card is not valid.");

        System.out.println();
        return isOver;
    }

    public boolean handleDrawCard(Player player) {
        Card card = deck.drawCard();
        player.receiveCard(card);

        System.out.println();
        System.out.println("Drawn Card: " + card.getCard());
        System.out.println();

        System.out.println(player.getName() + ", what do you want to do?");
        System.out.println("1) Play Drawn Card");
        System.out.println("2) Keep Drawn Card");
        int choice = Input.getIntInput("Enter your choice: ", 1, 2);

        switch (choice) {
            case 1:
                handlePlayDrawnCard(player);
                break;
            case 2:
                handleKeepDrawnCard(player);
                break;
        }

        System.out.println();
        return true;
    }

    public void handlePlayDrawnCard(Player player) {
        Card card = player.getCard(player.getHandSize());

        if (card.canPlayOn(getTopCard())) {
            player.playCard(player.getHandSize());
            pile.add(card);

            System.out.println();
            displayTopCard();

            card.applyCardEffect(this);
        } else {
            System.out.println("Invalid option! Card is not valid.");
            System.out.println("Turn skipped!");
            System.out.println();
            displayTopCard();
        }
    }

    public void handleKeepDrawnCard(Player player) {
        System.out.println("Turn skipped!");
        System.out.println();
        displayTopCard();
    }

    public void displayTopCard() {
        Card card = getTopCard();
        System.out.println("Top Card: " + card.getCard());

        if (getTopCard() instanceof WildCard && !card.getColor().equals("NONE"))
            System.out.println("Active Color: " + ((WildCard) card).getActiveColor());
    }

    public void checkIfUno(Player player) {
        if (player.hasUno()) {
            player.shoutUno();
            System.out.println();
        }
    }

    public void checkIfGameOver(Player player) {
        if (player.isHandEmpty())
            isGameOver = true;
    }

    public void displayWinner() {
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
