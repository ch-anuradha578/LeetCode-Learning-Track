package Day19;

/**
 * This class provides a method to determine whether a given number of flowers
 * can be placed in a flowerbed without violating the no-adjacent-flowers rule.
 */
public class CanPlaceFlowers {

    /**
     * Determines if 'n' flowers can be planted in the 'flowerbed' array without
     * planting any two flowers in adjacent plots.
     *
     * @param flowerbed An array representing the flowerbed where 0 means empty and 1 means occupied.
     * @param n         The number of new flowers to plant.
     * @return true if n flowers can be planted, otherwise false.
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;  // Count of flowers that can be planted

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                // Check if the left plot is empty or out of bounds
                boolean isLeftEmpty = ((i - 1) < 0 || flowerbed[i - 1] == 0);
                // Check if the right plot is empty or out of bounds
                boolean isRightEmpty = ((i + 1) >= flowerbed.length || flowerbed[i + 1] == 0);

                // If both sides are empty, a flower can be planted here
                if (isLeftEmpty && isRightEmpty) {
                    flowerbed[i] = 1; // Plant a flower
                    count++;          // Increment the planted flower count
                }
            }
        }

        // Return true if we were able to plant at least 'n' flowers
        return count >= n;
    }

    /**
     * Main method to test the canPlaceFlowers functionality.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        CanPlaceFlowers solution = new CanPlaceFlowers();

        int[] flowerbed = { 1, 0, 0, 0, 1 }; 
        int n = 1; 

        // Print the original flowerbed
        System.out.print("Given Array: [ ");
        for (int num : flowerbed) {
            System.out.print(num + " ");
        }
        System.out.println("]");

        // Display number of flowers to place
        System.out.println("Number of flowers to be planted: " + n);

        // Determine and display if planting is possible
        boolean result = solution.canPlaceFlowers(flowerbed, n);
        System.out.println("Can flowers be placed?: " + result);
    }
}
