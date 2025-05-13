package Day11;

public class FindMinimumSizeSubarraySum {
	public int minSubArrayLen(int target, int[] nums) {
		int minLenWindow = Integer.MAX_VALUE;
		int currSum = 0;

		int low = 0;

		for (int high = 0; high < nums.length; high++) {
			currSum += nums[high];

			while (currSum >= target) {
				int currWindowSize = high - low + 1;

				minLenWindow = Math.min(minLenWindow, currWindowSize);
				currSum -= nums[low];
				low++;
			}
		}
		return minLenWindow == Integer.MAX_VALUE ? 0 : minLenWindow;
	}
	public static void main(String[] args) {
		FindMinimumSizeSubarraySum solution = new FindMinimumSizeSubarraySum();

		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int target = 7;

		System.out.print("Input array: [");
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println("]");
		System.out.println("target: " + target);

		int result = solution.minSubArrayLen(target, nums);
		System.out.println("Max Consecutive Ones: " + result);
	}
}
