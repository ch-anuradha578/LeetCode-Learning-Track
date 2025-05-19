package Day15;

/**
 * This class provides a method to find the length of the longest subarray
 * consisting of 1's after deleting exactly one element from the binary array.
 */
public class LongestSubarrayofOnesAfterDeletingOneElement {

    /**
     * Finds the maximum length of a subarray that contains only 1's
     * after deleting one element from the original array.
     *
     * @param nums the input binary array (contains only 0s and 1s)
     * @return the length of the longest such subarray
     */
    public int longestSubarray(int[] nums) {
        int maxLenWindow = 0;
        int zeroCount = 0;
        int low = 0;

        for (int high = 0; high < nums.length; high++) {
            if (nums[high] == 0) {
                zeroCount++;
            }

            // Shrink the window if more than one zero is present
            while (zeroCount > 1) {
                if (nums[low] == 0) {
                    zeroCount--;
                }
                low++;
            }

            // Update maximum length found so far
            maxLenWindow = Math.max(maxLenWindow, high - low + 1);
        }

        // Subtract 1 because we must delete one element
        return maxLenWindow - 1;
    }

    /**
     * Main method to test the longestSubarray method.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        LongestSubarrayofOnesAfterDeletingOneElement solution = new LongestSubarrayofOnesAfterDeletingOneElement();

        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.print("Input: [");
        for (int num : nums) {
            System.out.print(num + ", ");
        }
        System.out.println("]");

        int result = solution.longestSubarray(nums);
        System.out.println("Longest subarray of 1's after deleting one element: " + result);
    }
}
