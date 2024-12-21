package hamming; // Declares the package for this Decoder class

import java.util.Scanner; // Imports the Scanner class for user input functionality

class Decoder { // Declares the Decoder class

    // Method to calculate the parity bit value for a given position
    private static int calculateParity(int[] hammingCode, int parityPosition) {
        int parity = 0; // Initialize parity value to 0 (used to check parity at the given position)
        for (int i = 1; i <= hammingCode.length; i++) { // Loop through all the bits in the Hamming code
            // Check if the current bit contributes to the parity at the given parity position
            if ((i & parityPosition) == parityPosition) {
                // XOR the parity with the bit value at the current position (needed for parity checking)
                parity ^= hammingCode[i - 1];
            }
        }
        return parity; // Return the calculated parity value
    }

    // Method to decode a Hamming code string and extract the original binary bits
    private static String decodeHammingCode(String encodedString) {
        // Convert the input string into an integer array, each element representing a bit of the Hamming code
        int[] hammingCode = new int[encodedString.length()];
        for (int i = 0; i < encodedString.length(); i++) { // Loop through each character of the input string
            // Convert character to its numeric value and store in the Hamming code array
            hammingCode[i] = Character.getNumericValue(encodedString.charAt(i));
        }

        // Variable to determine the error position in the Hamming code
        int errorPosition = 0;
        for (int i = 0; i < hammingCode.length; i++) { // Loop through the Hamming code to check for error positions
            int parityPosition = (int) Math.pow(2, i); // Calculate parity positions (1, 2, 4, 8, ...)
            if (parityPosition > hammingCode.length) { // Break if parity position exceeds the length of the Hamming code
                break;
            }
            // Calculate the current parity at this position
            int parity = calculateParity(hammingCode, parityPosition);
            if (parity != 0) { // If parity is not zero, it indicates an error at this position
                errorPosition += parityPosition; // Update the error position
            }
        }

        // Correct any detected errors in the Hamming code
        if (errorPosition > 0 && errorPosition <= hammingCode.length) { // If error position is valid
            System.out.println("Position of detected error: " + errorPosition); // Print the detected error position
            hammingCode[errorPosition - 1] ^= 1; // Flip the erroneous bit at the identified position
        }

        // Extract the original data bits from the Hamming code (ignoring the parity bits)
        StringBuilder originalData = new StringBuilder(); // StringBuilder to store the original data
        for (int i = 1; i <= hammingCode.length; i++) { // Loop through the Hamming code
            if ((i & (i - 1)) != 0) { // Skip parity bit positions (positions like 1, 2, 4, 8, ...)
                originalData.append(hammingCode[i - 1]); // Append non-parity bits to the original data string
            }
        }

        return originalData.toString(); // Return the extracted original data as a string
    }

    // Main method: Entry point for the program
    static void main() {

        System.out.println("Horacy Piguła, Indeks 122696, Grupa 5, SAN Łódź, Polska, kod Hamminga - dekoder");
        System.out.println("You are using Hamming Code Decoder which requires binary string encoded with Hamming algorithm as an output e.g.:11101010101 decoded binary data\n and will provide string of   . \n For binary string example the result will be 1101101 ");
        Scanner scanner = new Scanner(System.in); // Create a new Scanner object to read user input

        // Ask the user to input the Hamming code as a binary string
        System.out.println("Enter Hamming encoded binary code:");
        String hammingCode = scanner.next(); // Read user input for the Hamming code

        // Decode the Hamming code to retrieve the original binary data
        String originalBinaryData = decodeHammingCode(hammingCode);

        // Print the extracted original binary data
        System.out.println("Original binary code: " + originalBinaryData);

        scanner.close(); // Close the Scanner object to release system resources
    }
}