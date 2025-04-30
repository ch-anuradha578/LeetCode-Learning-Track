package Day2;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != nums[k]) {
				k++;
				nums[k] = nums[i];
			}
		}
		return k + 1;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

		System.out.print("Input Array: ");
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
		int result = solution.removeDuplicates(nums);
		System.out.print("Output array: ");
		for (int i = 0; i < result; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
