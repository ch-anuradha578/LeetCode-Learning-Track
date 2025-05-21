package Day17;

/**
 * The NumberOfOneBits class provides a method to calculate
 * the number of '1' bits (also known as the Hamming weight) in the
 * binary representation of an integer.
 */
public class NumberOfOneBits {

	 /**
     * Counts how many '1' bits are in the binary form of the given number.
     *
     * @param n the number to check
     * @return how many '1' bits are in the binary representation of n
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1); // Clears the least significant bit set
            count++;
        }
        return count;
    }

    /**
     * Main method to test the hammingWeight function.
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        NumberOfOneBits solution = new NumberOfOneBits();
        int n = 11;

        int result = solution.hammingWeight(n);
        
        System.out.println("Given Number: " + n);
        System.out.println("Hamming Weight: " + result);
    }
}
