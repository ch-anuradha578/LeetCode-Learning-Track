package Day5;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int start = 0, end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		SearchInsertPosition solution = new SearchInsertPosition();

		int[] nums = { 1, 3, 5, 6 };
		int target = 7;

		System.out.print("Input array: [ ");
		for (int num : nums) {
			System.out.print(num + ", ");
		}
		System.out.println("]");

		int result = solution.searchInsert(nums, target);
		System.out.println("Inserted Position: " + result);
	}
}
