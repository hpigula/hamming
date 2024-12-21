package hamming; // Declares the package for the codeDecode class

import java.util.Scanner; // Imports the Scanner class for user input

public class KodHammingaPigulaHoracy122696 {
    public static void main() { // Main method, entry point of the program

        System.out.println("Horacy Piguła, Indeks 122696, Grupa 5, SAN Łódź, Polska, kod Hamminga - dekoder i koder");

        System.out.println("Code of this app is also available on GitHub: https://github.com/hpigula/hamming.git");
        Scanner scanner = new Scanner(System.in); // Creates a Scanner instance for reading user input
        int choice = -1; // Variable to store user's menu choice, initialized to an invalid value

        // Loop to keep prompting the user until a valid choice is entered
        while (choice < 1 || choice > 2) {
            System.out.print("Choose (1.Decoder or 2 Encoder): "); // Prompts user to choose an option
            String input = scanner.nextLine().trim(); // Reads and trims user input

            try {
                // Try to parse the input as an integer
                choice = Integer.parseInt(input);

                // Handle the user's choice
                switch (choice) {
                    case 1: // Option 1: Hamming Code Decoding
                        System.out.println("Hamming Decoder");
                        Decoder.main(); // Calls the Decoder class (not provided here)
                        break;

                    case 2: // Option 2: Hamming Code Encoding
                        System.out.println("Hamming Encoder");
                        Coder.main(); // Calls the Coder class to generate Hamming code
                        break;


                    default:
                        // If choice is invalid
                        System.out.println("Wrong choice! please choose from  1 or 2");
                        choice = -1; // Reset choice to force valid input
                }
            } catch (NumberFormatException e) {
                // Handle invalid input (e.g., letters, empty input)
                System.out.println("Wrong choice! please choose from  1 or 2");
            }
        }
    }
}
