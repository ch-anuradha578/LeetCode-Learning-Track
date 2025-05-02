package Day4;

public class FindFirstAndLastElementPosition {
	public int[] searchRange(int[] nums, int target) {
		int first = -1;
		int last = -1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				if (first == -1) {
					first = i;
				}
				last = i;
			}
		}
		return new int[] { first, last };

	}

	public static void main(String[] args) {
		FindFirstAndLastElementPosition solution = new FindFirstAndLastElementPosition();
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 8;

		System.out.print("Input Array: [ ");
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println("]");

		int[] result = solution.searchRange(nums, target);
		System.out.print("Output Array: [ ");
		for (int res : result) {
			System.out.print(res + " ");
		}
		System.out.println("]");
	}
}
