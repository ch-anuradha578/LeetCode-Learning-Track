package Day10;

import java.util.Arrays;

public class MaxNumberofKSumPairs {
	public int maxOperations(int[] nums, int k) {
		Arrays.sort(nums);
		int res = 0;
		int start = 0, end = nums.length - 1;

		while (start < end) {
			if (nums[start] + nums[end] > k)
				end--;
			else if (nums[start] + nums[end] < k)
				start++;

			else {
				start++;
				end--;
				res++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		MaxNumberofKSumPairs solution = new MaxNumberofKSumPairs();
		int[] nums = { 1, 2, 3, 4, 5 };
		int k = 5;

		System.out.print("Input array: [");
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println("]");
		
		System.out.println("K: " + k);
		
		int result = solution.maxOperations(nums, k);
		System.out.println("Max Operations of K-Sum Pairs: " + result);
	}
}
