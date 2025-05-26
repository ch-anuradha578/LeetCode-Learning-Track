package Day20;

/**
 * SortArray class provides functionality to sort an array using the Merge Sort
 * algorithm. This implementation divides the array into subarrays, sorts them
 * recursively, and merges them back.
 */
public class SortArray {

	/**
	 * Sorts the given array using Merge Sort algorithm.
	 * 
	 * @param nums The array to be sorted.
	 * @return The sorted array.
	 */
	public int[] sortArray(int[] nums) {
		mergeSort(nums, 0, nums.length - 1);
		return nums;
	}

	/**
	 * Recursively divides the array into two halves, sorts each half, and then
	 * merges them.
	 *
	 * @param nums  The array to sort.
	 * @param start The starting index of the array segment.
	 * @param end   The ending index of the array segment.
	 */
	public void mergeSort(int[] nums, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2; 
			mergeSort(nums, start, mid); // Sort left half
			mergeSort(nums, mid + 1, end); // Sort right half
			merge(nums, start, mid, end); // Merge the sorted halves
		}
	}

	/**
	 * Merges two sorted subarrays of nums[]. 
	 * First subarray is nums[start..mid]
	 * Second subarray is nums[mid+1..end]
	 *
	 * @param nums  The array containing the subarrays to merge.
	 * @param start The starting index of the first subarray.
	 * @param mid   The ending index of the first subarray.
	 * @param end   The ending index of the second subarray.
	 */
	public void merge(int[] nums, int start, int mid, int end) {
		int n1 = mid - start + 1;
		int n2 = end - mid;

		int[] arr1 = new int[n1];
		int[] arr2 = new int[n2];

		// Copy data to temp arrays
		for (int i = 0; i < n1; i++) {
			arr1[i] = nums[start + i];
		}
		for (int i = 0; i < n2; i++) {
			arr2[i] = nums[mid + 1 + i];
		}

		int i = 0, j = 0, k = start;

		// Merge the temp arrays back into nums[]
		while (i < n1 && j < n2) {
			if (arr1[i] <= arr2[j]) {
				nums[k++] = arr1[i++];
			} else {
				nums[k++] = arr2[j++];
			}
		}

		// Copy remaining elements of arr1[] if any
		while (i < n1)
			nums[k++] = arr1[i++];

		// Copy remaining elements of arr2[] if any
		while (j < n2)
			nums[k++] = arr2[j++];
	}

	/**
	 * Main method to demonstrate sorting an array using the SortArray class.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		SortArray solution = new SortArray();
		int[] nums = { 5, 2, 3, 1 };

		// Print Given Array
		System.out.print("Given Array: [ ");
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println("]");

		int[] result = solution.sortArray(nums);

		// Print Sorted Array
		System.out.print("Sorted Array: [ ");
		for (int res : result) {
			System.out.print(res + " ");
		}
		System.out.println("]");
	}
}
