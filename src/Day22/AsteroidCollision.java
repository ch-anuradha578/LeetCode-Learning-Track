package Day22;

import java.util.Arrays;
import java.util.Stack;

/**
 * Simulates asteroid collisions using a stack.
 */
class Solution {
	/**
	 * Handles asteroid collisions.
	 * 
	 * @param asteroids Array of asteroids.
	 * @return Remaining asteroids after all collisions.
	 */
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < asteroids.length; i++) {
			int current = asteroids[i];
			boolean shouldPush = true;

			// Check for collision: left-moving asteroid meets right-moving one
			while (!stack.isEmpty() && current < 0 && stack.peek() > 0) {
				int top = stack.peek();

				if (Math.abs(top) < Math.abs(current)) {
					stack.pop(); // top destroyed
				} else if (Math.abs(top) == Math.abs(current)) {
					stack.pop(); // both destroyed
					shouldPush = false;
					break;
				} else {
					shouldPush = false; // current destroyed
					break;
				}
			}

			if (shouldPush) {
				stack.push(current); // push surviving asteroid
			}
		}

		// Convert stack to array
		int[] res = new int[stack.size()];
		for (int i = res.length - 1; i >= 0; i--) {
			res[i] = stack.pop();
		}

		return res;
	}
}

/**
 * Main class to run and test asteroid collision.
 */
public class AsteroidCollision {
	public static void main(String[] args) {
		Solution sol = new Solution();

		// Input asteroid array
		int[] asteroids = { 5, 10, -5 };

		// Print input
		System.out.println("Input asteroids: " + Arrays.toString(asteroids));

		// Run collision simulation
		int[] result = sol.asteroidCollision(asteroids);

		// Print result
		System.out.println("Remaining after collision: " + Arrays.toString(result));
	}
}
