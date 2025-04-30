package Day2;

import java.util.Arrays;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] result = new int[m + n];

		for (int i = 0; i < m; i++) {
			result[i] = nums1[i];
		}
		for (int j = 0; j < n; j++) {
			result[m + j] = nums2[j];
		}
		Arrays.sort(result);
		for (int i = 0; i < m + n; i++) {
			nums1[i] = result[i];
		}
		return;
	}

	public static void main(String[] args) {
		MergeSortedArray solution = new MergeSortedArray();
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		int m = 3;
		int n = 3;
		solution.merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
	}

}
