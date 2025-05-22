package Day18;

import java.util.*;

/**
 * This class provides a method to find all unique triplets in an array
 * that sum to zero (3Sum problem).
 */
public class ThreeSum {

    /**
     * Finds all unique triplets in the input array that sum up to zero.
     *
     * @param nums An array of integers.
     * @return A list of unique triplets that sum to zero.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3)
            return new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        // Fix the first element and use two pointers for the rest
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Add sorted triplet to ensure uniqueness
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0)
                    left++;   // Increase sum
                else
                    right--;  // Decrease sum
            }
        }

        return new ArrayList<>(result);
    }

    /**
     * Main method to test the threeSum function.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();

        // Sample input array
        int[] nums = { -1, 0, 1, 2, -1, -4 };

        // Print input array
        System.out.print("Given Array: [ ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("]");

        // Find and print all triplets that sum to zero
        List<List<Integer>> result = solution.threeSum(nums);

        System.out.println("Triplets that sum to zero:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
