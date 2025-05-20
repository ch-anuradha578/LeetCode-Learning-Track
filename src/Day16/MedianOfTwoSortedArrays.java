package Day16;

/**
 * This class provides a method to find the median of two sorted arrays using binary search.
 * It runs in O(log(min(m, n))) time, where m and n are the lengths of the input arrays.
 */
public class MedianOfTwoSortedArrays {

    /**
     * Finds the median of two sorted arrays.
     * This uses binary search to partition the arrays and calculate the median efficiently.
     *
     * @param nums1 First sorted array
     * @param nums2 Second sorted array
     * @return Median of the two arrays
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to optimize binary search
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int start = 0, end = m;

        // Binary search on nums1
        while (start <= end) {
            int part1 = (start + end) / 2;
            int part2 = (m + n + 1) / 2 - part1;

            // Handle edge cases using Integer.MIN/MAX
            int maxLeft1 = (part1 == 0) ? Integer.MIN_VALUE : nums1[part1 - 1];
            int minRight1 = (part1 == m) ? Integer.MAX_VALUE : nums1[part1];

            int maxLeft2 = (part2 == 0) ? Integer.MIN_VALUE : nums2[part2 - 1];
            int minRight2 = (part2 == n) ? Integer.MAX_VALUE : nums2[part2];

            // Check if we have found the correct partition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // If total number of elements is even
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
                // If total number of elements is odd
                else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            }
            // Too far on the right side of nums1, move left
            else if (maxLeft1 > minRight2) {
                end = part1 - 1;
            }
            // Too far on the left side of nums1, move right
            else {
                start = part1 + 1;
            }
        }

        // Should never reach here if arrays are sorted
        throw new IllegalArgumentException("Input arrays are not sorted or invalid.");
    }

    /**
     * Main method to test the median-finding logic with sample inputs.
     */
    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();

        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = { 4, 5, 6, 7, 8 };

        // Print Input Array1
        System.out.print("Array1: [ ");
        for (int num1 : nums1) {
            System.out.print(num1 + " ");
        }
        System.out.println("]");

        // Print Input Array2
        System.out.print("Array2: [ ");
        for (int num2 : nums2) {
            System.out.print(num2 + " ");
        }
        System.out.println("]");

        // Find and print median
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median: " + result); 
    }
}
