import java.util.Scanner;

public class NLPRunner {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Initialize the PasswordChecker by loading necessary data from files
        PasswordChecker.initialize();

        // Prompt the user to enter a password to check its strength
        System.out.println("Enter a password to check:");
        // Read the password entered by the user
        String password = scanner.nextLine();

        // Call the PasswordChecker method to analyze the entered password
        PasswordChecker.checkPassword(password);

        // Close the scanner
        scanner.close();
    }
}
