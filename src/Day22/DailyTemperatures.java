package Day22;

import java.util.Stack;
import java.util.Arrays;

/**
 * This class solves the Daily Temperatures problem.
 * For each day, it returns how many days to wait for a warmer temperature.
 */
public class DailyTemperatures {

    /**
     * Finds days to wait for a warmer temperature.
     *
     * @param temperatures array of daily temperatures
     * @return array with days to wait for each day
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> helperStack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];

        // Loop from last day to first
        for (int idx = n - 1; idx >= 0; idx--) {
            // Remove days with equal or lower temp
            while (!helperStack.isEmpty() && temperatures[idx] >= temperatures[helperStack.peek()]) {
                helperStack.pop();
            }

            // If stack not empty, calculate wait time
            if (!helperStack.isEmpty()) {
                result[idx] = helperStack.peek() - idx;
            }

            // Push current day index
            helperStack.push(idx);
        }

        return result;
    }

    /**
     * Main method to test dailyTemperatures method.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
    	DailyTemperatures solution = new DailyTemperatures();

        // Input temperatures
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        // Print input
        System.out.println("Input temperatures: " + Arrays.toString(temperatures));

        // Call method
        int[] result = solution.dailyTemperatures(temperatures);

        // Print output
        System.out.println("Days to wait: " + Arrays.toString(result));
    }
}
