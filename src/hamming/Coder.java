package hamming; // Declares the package this class belongs to

import java.util.*; // Imports all classes from the java.util package (required for Scanner)

public class Coder {
    public static void main() { // Main method that serves as the entry point of the program.
        Scanner scanner = new Scanner(System.in); // Create a new Scanner object to read input from the user.

        // Prompt the user to enter binary data
        System.out.print("Enter the binary data: "); // Print a message asking the user to enter binary data.
        String data = scanner.nextLine(); // Read the user's input as a string and store it in the variable 'data'.

        // Calculate the Hamming code
        int[] hammingCode = calculateHammingCode(data); // Call the method 'calculateHammingCode' with the user's input and store the result in the array 'hammingCode'.

        // Print the Hamming code
        System.out.print("Hamming code: "); // Print a message indicating that the Hamming code is being displayed.
        for (int bit : hammingCode) { // Loop through each element in the 'hammingCode' array.
            System.out.print(bit); // Print the current element of the array.
        }
        System.out.println(); // Print a newline character to move to the next line after printing the Hamming code.
    }

    /**
     * Calculate the Hamming code for the given binary data.
     *
     * @param data The binary data as a string.
     * @return The Hamming code as an array of integers.
     */
    public static int[] calculateHammingCode(String data) { // Method that calculates the Hamming code for a given binary string.
        int m = data.length(); // Get the length of the input binary string and store it in the variable 'm'.
        int r = 0; // Initialize a variable 'r' to keep track of the number of parity bits.

        // Determine the number of parity bits
        while (Math.pow(2, r) <= m + r) { // Loop until the power of 2 raised to 'r' is greater than the sum of 'm' and 'r'.
            r++; // Increment 'r' by 1 in each iteration.
        }

        // Initialize the array with the data bits
        int[] arr = new int[m + r]; // Create a new integer array 'arr' with a length equal to the sum of 'm' and 'r'.
        int j = 0; // Initialize a variable 'j' to keep track of the position in the input binary string.
        for (int i = 1; i <= m + r; i++) { // Loop through each element in the array 'arr'.
            if ((i & (i - 1)) != 0) {  // Check if 'i' is not a power of 2 using bitwise AND operation.
                arr[i - 1] = Character.getNumericValue(data.charAt(j)); // Convert the character at position 'j' in the input string to an integer and store it in the array 'arr'.
                j++; // Increment 'j' by 1 to move to the next character in the input string.
            }
        }

        // Calculate the parity bits
        for (int i = 0; i < r; i++) { // Loop through each parity bit position.
            int parityPos = (int) Math.pow(2, i) - 1; // Calculate the position of the current parity bit using power of 2 and subtracting 1.
            int parity = 0; // Initialize a variable 'parity' to keep track of the parity value.
            for (int l = parityPos; l < m + r; l += 2 * (int) Math.pow(2, i)) { // Loop through each group of bits that need to be included in the current parity calculation.
                for (int k = 0; k < Math.pow(2, i); k++) { // Loop through each bit in the current group.
                    if (l + k < m + r) { // Check if the current bit position is within the bounds of the array 'arr'.
                        parity ^= arr[l + k]; // Perform an XOR operation between the current parity value and the bit at position 'l+k' in the array 'arr'.
                    }
                }
            }
            arr[parityPos] = parity; // Store the calculated parity value in the array 'arr' at the position of the current parity bit.
        }

        return arr; // Return the array 'arr' containing the Hamming code.
    }
}