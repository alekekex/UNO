import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Welcome to UNO!");
            System.out.println("1) Play Game");
            System.out.println("2) Exit Program");
            int choice = Input.getIntInput(sc, "Enter your choice: ", 1, 2);

            switch (choice) {
                case 1:
                    UNO game = new UNO();

                    int count = Input.getIntInput(sc, "Enter number of players: ", 2, -1);
                    List<String> names = Input.getPlayerNames(sc, count);

                    game.initializePlayers(names);
                    game.playGame(sc);
                    break;
                case 2:
                    isRunning = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
            }
        }

        sc.close();
    }
}
