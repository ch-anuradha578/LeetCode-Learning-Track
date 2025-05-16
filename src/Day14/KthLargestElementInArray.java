package Day14;

import java.util.PriorityQueue;

/**
 * This class provides a method to find the Kth largest element in an unsorted array.
 * It uses a min-heap (PriorityQueue) to efficiently find the Kth largest element.
 */
public class KthLargestElementInArray {

    /**
     * Finds the Kth largest element in the given array.
     *
     * @param nums The input array of integers.
     * @param k    The "Kth" largest element to find.
     * @return The Kth largest element in the array.
     */
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to store the top k largest elements
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add first k elements into the min-heap
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        // Iterate through the rest of the array
        for (int i = k; i < nums.length; i++) {
            // If current element is larger than the smallest in the heap
            if (pq.peek() < nums[i]) {
                pq.poll(); // Remove the smallest
                pq.add(nums[i]); // Add the current element
            }
        }

        // The root of the heap is the Kth largest element
        return pq.peek();
    }

    /**
     * Main method for testing the findKthLargest function.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        KthLargestElementInArray solution = new KthLargestElementInArray();

        int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k = 4;

        System.out.print("Input: [ ");
        for (int num : nums) {
            System.out.print(num + ", ");
        }
        System.out.println("]");

        System.out.println("Kth: The largest element which is to be find: " + k);

        int result = solution.findKthLargest(nums, k);
        System.out.println("Result(The largest element in the array): " + result);
    }
}
