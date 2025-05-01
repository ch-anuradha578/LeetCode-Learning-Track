package Day3;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int arrLen = nums.length;
        k = k % arrLen;
        reverse(nums, 0, arrLen - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, arrLen - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray solution = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.print("Input array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        solution.rotate(nums, k);

        System.out.print("Output array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
