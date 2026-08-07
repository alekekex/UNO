import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("----------- MAIN MENU -----------");
            System.out.println("Welcome to UNO!");
            System.out.println("1) Play Game");
            System.out.println("2) Exit Program");
            int choice = Input.getIntInput("Enter your choice: ", 1, 2);
            System.out.println();

            switch (choice) {
                case 1:
                    UNO game = new UNO();

                    System.out.println("---------- PLAYER SETUP ----------");
                    int count = Input.getIntInput("Enter number of players: ", 2, 10);
                    List<String> names = Input.getPlayerNames(count);
                    System.out.println();

                    game.initializePlayers(names);
                    game.playGame();
                    break;
                case 2:
                    isRunning = false;
                    System.out.println("-------------- EXIT --------------");
                    System.out.println("Thanks for playing UNO!");
                    System.out.println("Goodbye!");
                    break;
            }
        }

        Input.close();
    }
}
