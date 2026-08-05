public class ActionCard extends Card {
    public ActionCard(String value, String color) {
        super(value, color);
    }

    @Override
    public void applyCardEffect(UNO game) {
        System.out.println("Action Card Effect Implemented!");
    }
}
