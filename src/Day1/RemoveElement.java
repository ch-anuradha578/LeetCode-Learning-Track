package Day1;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();

        int[] nums = {3, 2, 2, 3};
        int val = 3;
        
        System.out.print("Input array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        int result = solution.removeElement(nums, val);

        System.out.println("Updated length: " + result);
        System.out.print("Updated array: ");
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
