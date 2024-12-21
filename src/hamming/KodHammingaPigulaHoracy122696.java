package hamming; // Declares the package for the codeDecode class

import java.util.Scanner; // Imports the Scanner class for user input

public class KodHammingaPigulaHoracy122696 {
    public static void main() { // Main method, entry point of the program
        // Prints program details and usage instructions in Polish
        System.out.println("Horacy Piguła, Indeks 122696, Grupa 5, SAN Łódź, Polska, kod Hamminga - dekoder i koder");
        System.out.println("Jest to program do kodowania i dekodowania kodu Hamminga. \nDo wyboru są opcje:\n 1. Dekodowanie Kodu Hamminga \n 2. Kodowanie Hamminga \n 3. Wyjście z aplikacji");

        Scanner scanner = new Scanner(System.in); // Creates a Scanner instance for reading user input
        int choice = -1; // Variable to store user's menu choice, initialized to an invalid value

        // Loop to keep prompting the user until a valid choice is entered
        while (choice < 1 || choice > 3) {
            System.out.print("Wybierz opcję (1, 2, lub 3): "); // Prompts user to choose an option
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
                        System.out.println("Zły wybór proszę wybrać jedną z opcji => 1, 2, lub 3.");
                        choice = -1; // Reset choice to force valid input
                }
            } catch (NumberFormatException e) {
                // Handle invalid input (e.g., letters, empty input)
                System.out.println("Błędne dane wejściowe! Proszę wybrać 1, 2 lub 3.");
            }
        }
    }
}