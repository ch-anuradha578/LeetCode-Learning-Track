package Day18;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A class that provides functionality to find the difference between two integer arrays.
 * Specifically, it identifies elements that are unique to each array.
 */
public class FindTheDifferenceOfTwoArrays {

    /**
     * Finds the unique elements in each of the two input arrays.
     * 
     * @param nums1 The first integer array
     * @param nums2 The second integer array
     * @return A list of two lists:
     *         - First list contains elements in nums1 not in nums2
     *         - Second list contains elements in nums2 not in nums1
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Convert nums1 and nums2 to sets to remove duplicates
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Fill set1 with elements from nums1
        for (int num : nums1) {
            set1.add(num);
        }

        // Fill set2 with elements from nums2
        for (int num : nums2) {
            set2.add(num);
        }

        // List to store elements unique to nums1
        List<Integer> diff1 = new ArrayList<>();
        for (int num : set1) {
            if (!set2.contains(num)) {
                diff1.add(num);
            }
        }

        // List to store elements unique to nums2
        List<Integer> diff2 = new ArrayList<>();
        for (int num : set2) {
            if (!set1.contains(num)) {
                diff2.add(num);
            }
        }

        // Combine both results into a single list of lists
        List<List<Integer>> result = new ArrayList<>();
        result.add(diff1);
        result.add(diff2);

        return result;
    }

    /**
     * Main method to test the findDifference function with sample input arrays.
     * It prints the unique elements from each array.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        FindTheDifferenceOfTwoArrays solution = new FindTheDifferenceOfTwoArrays();

        // Sample input arrays
        int[] nums1 = { 1, 2, 3, 3 };
        int[] nums2 = { 2, 2, 4, 6 };

        // Print input array 1
        System.out.print("Array 1: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Print input array 2
        System.out.print("Array 2: ");
        for (int num : nums2) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Find and print the differences
        List<List<Integer>> result = solution.findDifference(nums1, nums2);

        // Output the results
        System.out.println("Unique to Array 1: " + result.get(0));
        System.out.println("Unique to Array 2: " + result.get(1));
    }
}
