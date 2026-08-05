import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Input {
    public static int getIntInput(Scanner sc, String prompt, int min, int max) {
        boolean isValid = false;
        int n = -1;

        do {
            try {
                System.out.print(prompt);
                n = sc.nextInt();
                sc.nextLine();

                if (max == -1) {
                    if (n < min)
                        System.out.println("Invalid option! Value must be at least " + min + ".");
                    else isValid = true;
                } else {
                    if (!(n >= min && n <= max))
                        System.out.println("Invalid option! Please enter a value between " +
                                min + " and " + max + ".");
                    else isValid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
            }
        } while (!isValid);

        return n;
    }

    public static List<String> getPlayerNames(Scanner sc, int n) {
        List<String> names = new ArrayList<>();
        boolean isValid;
        String name;

        for (int i = 0; i < n; i++) {
            do {
                isValid = false;
                System.out.print("Enter name of Player " + (i + 1) + ": ");
                name = sc.nextLine();

                if (name.isEmpty() || name.isBlank())
                    System.out.println("Invalid input! Please enter a valid name.");
                else {
                    isValid = true;
                    names.add(name);
                }
            } while (!isValid);
        }

        return names;
    }
}
