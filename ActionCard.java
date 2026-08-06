public class ActionCard extends Card {
    public ActionCard(String value, String color) {
        super(value, color);
    }

    @Override
    public void applyCardEffect(UNO game) {
        switch (getValue()) {
            case "S":
                System.out.println("Effect: Skip next player");
                game.skipNextPlayer();
                break;
            case "R":
                System.out.println("Effect: Reverse turn order");
                game.reverseDirection();
                break;
            case "+2":
                System.out.println("Effect: Add 2 cards to next player");
                game.drawTwo();
                break;
        }
    }
}
