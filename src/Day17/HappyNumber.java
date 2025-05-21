package Day17;

import java.util.HashSet;
import java.util.Set;

/**
 * The HappyNumber class provides a method to determine
 * whether a given number is a "happy number".
 */
public class HappyNumber {

    /**
     * Determines whether the given number is a happy number.
     *
     * @param n the number to check
     * @return true if the number is happy, false otherwise
     */
    public boolean isHappy(int n) {
        Set<Integer> visitedNumbers = new HashSet<>();

        while (true) {
            // Find the sum of the squares of the digits
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2.0);
                n = n / 10;
            }

            // If sum is 1, the number is happy
            if (sum == 1)
                return true;

            // Update n to the new sum
            n = sum;

            // Check if we have visited this number before
            if (visitedNumbers.contains(n))
                return false;
            else
            	visitedNumbers.add(n);
        }
    }

    /**
     * The main method to test the isHappy method.
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();

        int n = 19;
        boolean result = solution.isHappy(n);

        System.out.println("Given Number: " + n);
        System.out.println("Is given number is a HappyNumber?: " + result);
    }
}
