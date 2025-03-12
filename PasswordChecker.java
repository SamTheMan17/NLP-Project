import java.util.ArrayList;

public class PasswordChecker {
    // Declare static lists to store valid characters for lowercase, uppercase, numbers, symbols, and common sequences
    private static ArrayList<String> lower;
    private static ArrayList<String> upper;
    private static ArrayList<String> numbers;
    private static ArrayList<String> symbols;
    private static ArrayList<String> sequences;

    // Method to initialize lists from external files
    public static void initialize() {
        lower = FileReader.toStringList("LowerCase.txt");   // Load lowercase letters from file
        upper = FileReader.toStringList("UpperCase.txt");   // Load uppercase letters from file
        numbers = FileReader.toStringList("Numbers.txt");   // Load numbers from file
        symbols = FileReader.toStringList("Characters.txt"); // Load symbols from file
        sequences = FileReader.toStringList("Sequences.txt"); // Load common sequences from file
    }

    // Method to check the strength of the given password
    public static void checkPassword(String password) {
        int lowerCount = 0;   // Counter for lowercase letters
        int upperCount = 0;   // Counter for uppercase letters
        int numCount = 0;     // Counter for numbers
        int symbolCount = 0;  // Counter for special characters

        // Loop through each character of the password to count types of characters
        for (int i = 0; i < password.length(); i++) {
            String letter = password.substring(i, i + 1); // Extract a single character
            // Check if the character is lowercase
            if (lower.contains(letter)) {
                lowerCount++;
            // Check if the character is uppercase
            } else if (upper.contains(letter)) {
                upperCount++;
            // Check if the character is a number
            } else if (numbers.contains(letter)) {
                numCount++;
            // Check if the character is a symbol
            } else if (symbols.contains(letter)) {
                symbolCount++;
            }
        }

        // Output the analysis of the password
        System.out.println("Password Analysis:");
        System.out.println("Length: " + password.length());
        System.out.println("Uppercase letters: " + upperCount);
        System.out.println("Lowercase letters: " + lowerCount);
        System.out.println("Numbers: " + numCount);
        System.out.println("Symbols: " + symbolCount);

        // Check for specific password length and composition requirements
        if (password.length() != 7) {
            System.out.println("Issue: Password must be exactly 7 characters.");
        }
        if (upperCount == 0) {
            System.out.println("Issue: Password should contain at least one uppercase letter.");
        }
        if (lowerCount == 0) {
            System.out.println("Issue: Password should contain at least one lowercase letter.");
        }
        if (numCount == 0) {
            System.out.println("Issue: Password should contain at least one number.");
        }
        if (symbolCount == 0) {
            System.out.println("Issue: Password should contain at least one special character.");
        }
        
        // Check for common sequences in the password
        checkCommonSequences(password);

        // If all conditions are met, print success 
        if (password.length() == 7 && upperCount > 0 && lowerCount > 0 && numCount > 0 && symbolCount > 0) {
            System.out.println("Success: This password is strong!");
        }
    }

    // Method to check if the password contains any common sequences
    // Preconditions: Password must be a non-null string
    // Postconditions: If a common sequence is found, a warning message will be printed
    private static void checkCommonSequences(String password) {
        // Loop through all common sequences and check if the password contains any of them
        for (String sequence : sequences) {
            if (password.toUpperCase().contains(sequence)) {
                System.out.println("Warning: Your password contains a common sequence (" + sequence + "). Consider changing it.");
            }
        }
    }
}
