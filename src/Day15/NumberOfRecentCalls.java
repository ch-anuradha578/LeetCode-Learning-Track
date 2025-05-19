package Day15;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The RecentCounter class which counts the number of recent requests within the
 * past 3000 milliseconds.
 */
public class NumberOfRecentCalls {

	/**
	 * This class implements the logic to maintain and query recent pings that have
	 * occurred within the last 3000 milliseconds.
	 */
	static class RecentCounter {
		private Queue<Integer> queue;

		/**
		 * Constructor to initialize the queue that will store the timestamps of pings.
		 */
		public RecentCounter() {
			queue = new LinkedList<>();
		}

		/**
		 * This method records a new ping at time `t` and returns the number of pings
		 * that occurred within the last 3000 milliseconds (including the current ping).
		 * 
		 * @param t The timestamp of the current ping.
		 * @return The number of pings in the last 3000 milliseconds.
		 */
		public int ping(int t) {
			queue.add(t); // Add the current ping timestamp to the queue.

			// Remove pings that are outside the 3000ms window.
			while (!queue.isEmpty() && t - 3000 > queue.peek()) {
				queue.poll(); // Remove the ping at the front if it's older than 3000ms.
			}

			// Return the number of pings within the 3000ms window.
			return queue.size();
		}
	}

	/**
	 * Main method to test the RecentCounter class. It simulates pings and prints
	 * the number of recent pings that occurred within the last 3000ms for each test
	 * case.
	 * 
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		RecentCounter obj = new RecentCounter();

		// Test cases
		System.out.println("Input:{ ping(1), ping(100), ping(3001), ping(3002) }");
		System.out.println(
				"Output: {" + obj.ping(1) + ", " + obj.ping(100) + ", " + obj.ping(3001) + ", " + obj.ping(3002) + "}");
	}
}
