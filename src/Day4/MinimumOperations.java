package Day4;

import java.util.HashSet;
import java.util.Set;

public class MinimumOperations {
	public int minOperations(int[] nums, int k) {
		Set<Integer> mySet = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < k) {
				return -1;
			} else if (nums[i] > k) {
				mySet.add(nums[i]);
			}
		}
		return mySet.size();
	}

	public static void main(String[] args) {
		MinimumOperations solution = new MinimumOperations();
		int[] nums = { 5, 2, 5, 4, 5 };
		int k = 2;

		System.out.print("Input Array: [ ");
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println("]");

		int result = solution.minOperations(nums, k);
		System.out.print("Count of mininum operation to make array value equal to k is " + result);

	}
}
