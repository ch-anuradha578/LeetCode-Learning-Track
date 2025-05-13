package Day11;

public class FindMaxConsecutiveOnes {
	public int longestOnes(int[] nums, int k) {
		int maxLenWindow = 0;
		int zeroCount = 0;

		int low = 0;

		for (int high = 0; high < nums.length; high++) {
			if (nums[high] == 0) {
				zeroCount++;
			}

			while (zeroCount > k) {
				if (nums[low] == 0) {
					zeroCount--;
				}
				low++;
			}
			maxLenWindow = Math.max(maxLenWindow, high - low + 1);
		}

		return maxLenWindow;
	}

	public static void main(String[] args) {
		FindMaxConsecutiveOnes solution = new FindMaxConsecutiveOnes();

		int[] nums = { 1,1,1,0,0,0,1,1,1,1,0 };
		int k = 2;

		System.out.print("Input array: [");
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println("]");

		System.out.println("K: " + k);

		int result = solution.longestOnes(nums, k);
		System.out.println("Max Consecutive Ones: " + result);
	}
}
