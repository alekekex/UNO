import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Welcome to UNO!");
            System.out.println("1) Play Game");
            System.out.println("2) Exit Program");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    UNO game = new UNO();
                    // player initialization and game start
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }

        sc.close();
    }
}
