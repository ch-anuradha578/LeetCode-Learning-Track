package Day19;

/**
 * This class provides a method to find the maximum number of consecutive 1s in a binary array.
 */
public class MaxConsecutiveOnes {

    /**
     * Finds the maximum number of consecutive 1s in the input binary array.
     *
     * @param nums The input array consisting of only 0s and 1s.
     * @return The length of the longest sequence of consecutive 1s.
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;    // Stores the maximum sequence found so far
        int count = 0;  // Counts the current sequence of 1s

        // Iterate through each number in the array
        for (int num : nums) {
            if (num == 1) {
                count++;              // Increment current count if 1
                max = Math.max(max, count); // Update max if needed
            } else {
                count = 0;            // Reset count if a 0 is found
            }
        }

        return max;
    }

    /**
     * Main method to test the findMaxConsecutiveOnes functionality.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        MaxConsecutiveOnes solution = new MaxConsecutiveOnes();

        int[] nums = { 1, 1, 0, 1, 1, 1 }; 

        // Print the original array
        System.out.print("Given Array: [ ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("]");

        // Compute and print the result
        int result = solution.findMaxConsecutiveOnes(nums);
        System.out.println("Maximum number of consecutive 1's in the array: " + result);
    }
}
