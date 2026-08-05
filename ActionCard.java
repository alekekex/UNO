public class ActionCard extends Card {
    public ActionCard(String value, String color) {
        super(value, color);
    }

    @Override
    public void applyCardEffect(UNO game) {
        switch (getValue()) {
            case "S":
                System.out.println("Effect: Skipped next turn!"); // temp
                game.skipNextPlayer();
                break;
            case "R":
                System.out.println("Effect: Reversed turn order!"); // temp
                game.reverseDirection();
                break;
            case "+2":
                System.out.println("Effect: Added 2 cards to next player!"); // temp
                game.drawTwo();
                break;
        }
    }
}
