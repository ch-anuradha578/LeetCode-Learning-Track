package Day17;

/**
 * The HouseRobber class provides a method to solve the classic dynamic programming problem:
 * "House Robber".
 */
public class HouseRobber {

    /**
     * Returns the maximum amount of money that can be robbed without robbing two adjacent houses.
     * @param nums an array where each element represents the amount of money at a house
     * @return the maximum amount of money that can be robbed
     */
    public int rob(int[] nums) {
        // If there's only one house, return its value
        if (nums.length < 2)
            return nums[0];

        // Create array to store the max money that can be robbed up to each house
        int[] maxLootAtHouse = new int[nums.length];

        // Initialize the first two values
        maxLootAtHouse[0] = nums[0];
        maxLootAtHouse[1] = Math.max(nums[0], nums[1]);

        // Fill the array by choosing to either rob the current house or skip it
        for (int i = 2; i < nums.length; i++) {
            maxLootAtHouse[i] = Math.max(maxLootAtHouse[i - 2] + nums[i], maxLootAtHouse[i - 1]);
        }

        // The last element contains the maximum loot
        return maxLootAtHouse[nums.length - 1];
    }

    /**
     * The main method to test the rob function.
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        HouseRobber solution = new HouseRobber();
        int[] nums = { 2, 7, 9, 3, 1 };

        // Print input array
        System.out.print("Given Array: [ ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("]");

        int result = solution.rob(nums);

        // Print result
        System.out.println("Maximum amount of money that can be robbed: " + result);
    }
}
