public class WildCard extends Card {
    String activeColor;

    public WildCard(String value) {
        super(value, "GRAY");
    }

    public void setActiveColor(String activeColor) {
        this.activeColor = activeColor;
    }

    @Override
    public String getColor() {
        return activeColor;
    }

    @Override
    public void applyCardEffect(UNO game) {
        switch (getValue()) {
            case "CC":
                System.out.println("Effect: Changed color!"); // temp
                game.changeColor(this);
                break;
            case "+4":
                System.out.println("Effect: Added 4 cards to next player and changed color!"); // temp
                game.drawFour(this);
                break;
        }
    }

    @Override
    public boolean canPlayOn(Card card) {
        return true;
    }
}
