public class WildCard extends Card {
    public WildCard(String value) {
        super(value, "GRAY");
    }

    @Override
    public void applyCardEffect(UNO game) {
        switch (getValue()) {
            case "CC":
                System.out.println("Effect: Changed Color!"); // temp
                break;
            case "+4":
                System.out.println("Effect: Added 4 cards to next player and changed color!"); // temp
                break;
        }
    }

    @Override
    public boolean canPlayOn(Card card) {
        return true;
    }
}
