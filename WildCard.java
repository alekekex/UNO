public class WildCard extends Card {
    private String activeColor;

    public WildCard(String value) {
        super(value, "GRAY");
        this.activeColor = "NONE";
    }

    public void setActiveColor(String activeColor) {
        this.activeColor = activeColor;
    }

    public String getActiveColor() {
        String color;

        switch (activeColor) {
            case "RED":
                color = RED + "Red" + RESET;
                break;
            case "GREEN":
                color = GREEN + "Green" + RESET;
                break;
            case "YELLOW":
                color = YELLOW + "Yellow" + RESET;
                break;
            case "BLUE":
                color = BLUE + "Blue" + RESET;
                break;
            default:
                color = "None";
        }

        return color;
    }

    @Override
    public String getColor() {
        return activeColor;
    }

    @Override
    public void applyCardEffect(UNO game) {
        switch (getValue()) {
            case "CC":
                System.out.println("Effect: Change color");
                game.changeColor(this);
                break;
            case "+4":
                System.out.println("Effect: Add 4 cards to next player and change color");
                game.drawFour(this);
                break;
        }
    }

    @Override
    public boolean canPlayOn(Card card) {
        return true;
    }
}
