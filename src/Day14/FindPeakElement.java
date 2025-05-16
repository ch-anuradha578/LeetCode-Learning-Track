package Day14;

/**
 * This class provides a method to find a peak element in an array.
 * A peak element is an element that is strictly greater than its neighbors.
 */
public class FindPeakElement {
    /**
     * Finds a peak element and returns its index. If the array contains multiple peaks,
     * the method returns the index to any one of the peaks.
     *
     * @param nums The input array of integers.
     * @return The index of a peak element.
     */
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;

        // Check if the first element is a peak
        if (len == 1 || nums[0] > nums[1])
            return 0;
        // Check if the last element is a peak
        if (nums[len - 1] > nums[len - 2])
            return len - 1;

        int low = 1;
        int high = len - 2;

        // Binary search to find a peak
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If the element at mid is a peak element return mid
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // Move right if the right neighbor is greater
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                // Move left otherwise
                high = mid - 1;
            }
        }
        return 0;
    }

    /**
     * Main method for demonstrating the findPeakElement function.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        FindPeakElement solution = new FindPeakElement();
        int[] nums = { 1, 2, 1, 3, 5, 6, 4 };

        System.out.print("Input: [ ");
        for (int num : nums) {
            System.out.print(num + ", ");
        }
        System.out.println("]");

        int result = solution.findPeakElement(nums);
        System.out.println("Output (peak index): " + result);
    }
}
