public class WildCard extends Card {
    public WildCard(String value) {
        super(value, "GRAY");
    }

    @Override
    public void applyCardEffect(UNO game) {
        System.out.println("Wild Card Effect Implemented!");
    }
}
