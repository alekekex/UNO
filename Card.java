public class Card {
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String GRAY = "\u001B[38;5;244m";
    private static final String RESET = "\u001B[0m";

    private String type;
    private String value;
    private String color;

    public Card(String type, String value, String color) {
        this.type = type;
        this.value = value;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    public String getCard() {
        String card = "[" + value + "]";

        switch (color) {
            case "RED":
                card = RED + "[" + value + "]" + RESET;
                break;
            case "GREEN":
                card = GREEN + "[" + value + "]" + RESET;
                break;
            case "YELLOW":
                card = YELLOW + "[" + value + "]" + RESET;
                break;
            case "BLUE":
                card = BLUE + "[" + value + "]" + RESET;
                break;
            case "GRAY":
                card = GRAY + "[" + value + "]" + RESET;
                break;
        }

        return card;
    }
}
