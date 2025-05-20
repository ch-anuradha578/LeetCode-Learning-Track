package Day16;

/**
 * This class solves the "Container With Most Water" problem. Given an array of
 * heights, it finds two lines that together with the x-axis form a container
 * that holds the most water. The height of the container is determined by the
 * shorter of the two lines, and the width is the distance between them.
 */
public class ContainerWithMostWater {

	/**
	 * Calculates the maximum area of water that can be contained. Uses a
	 * two-pointer technique to find the optimal pair of lines.
	 *
	 * @param height An array of positive integers representing the height of
	 *               vertical lines.
	 * @return The maximum area of water that can be contained between two lines.
	 */
	public int maxArea(int[] height) {
		int left = 0; // Left pointer
		int right = height.length - 1; // Right pointer
		int max = 0; // Maximum area found so far

		// Move pointers toward each other, checking area at each step
		while (left < right) {
			int leftH = height[left]; // Height at left pointer
			int rightH = height[right]; // Height at right pointer

			// Calculate area = width * min height
			int minHeight = Math.min(leftH, rightH);
			int area = minHeight * (right - left);
			max = Math.max(max, area); // Update max if new area is larger

			// Move the pointer with the shorter line to try for a taller container
			if (leftH < rightH)
				left++;
			else
				right--;
		}

		return max;
	}

	/**
	 * Main method for testing the maxArea method.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		ContainerWithMostWater solution = new ContainerWithMostWater();
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

		// Print input array
		System.out.print("Input Array: [ ");
		for (int num : height) {
			System.out.print(num + " ");
		}
		System.out.println("]");

		// Calculate and print result
		int result = solution.maxArea(height);
		System.out.println("Maximum amount of water a container can store: " + result);
	}
}
