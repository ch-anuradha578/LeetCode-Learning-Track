package Day16;

import java.util.PriorityQueue;

/**
 * This class provides a method to calculate the total minimum cost of hiring k
 * workers. Workers are selected based on their cost, and the selection process
 * considers candidates from both ends of the list, using two min-heaps to
 * always pick the cheapest available options.
 */
public class TotalCostToHireKWorkers {

	/**
	 * Calculates the total minimum cost to hire exactly k workers. In each hiring
	 * step, up to 'candidates' number of workers from both ends of the array are
	 * considered.
	 *
	 * @param costs      An array where each element represents the cost of hiring a
	 *                   worker.
	 * @param k          The total number of workers to hire.
	 * @param candidates The number of candidates to consider from both ends in each
	 *                   step.
	 * @return The total minimum cost of hiring k workers.
	 */
	public long totalCost(int[] costs, int k, int candidates) {
		long result = 0; // Total cost accumulator
		int hired = 0; // Number of workers hired so far
		int i = 0, j = costs.length - 1; // Pointers to the start and end of the array

		// Min-heaps to store costs from the left and right side
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();

		// Keep hiring workers until k are hired
		while (hired < k) {

			// Fill pq1 with up to 'candidates' workers from the left (if available)
			while (pq1.size() < candidates && i <= j) {
				pq1.add(costs[i]);
				i++;
			}

			// Fill pq2 with up to 'candidates' workers from the right (if available)
			while (pq2.size() < candidates && j >= i) {
				pq2.add(costs[j]);
				j--;
			}

			// Get the minimum cost from both heaps, or Integer.MAX_VALUE if empty
			int min_pq1 = pq1.isEmpty() ? Integer.MAX_VALUE : pq1.peek();
			int min_pq2 = pq2.isEmpty() ? Integer.MAX_VALUE : pq2.peek();

			// Hire the worker with the lower cost and remove from the heap
			if (min_pq1 <= min_pq2) {
				result += min_pq1;
				pq1.poll();
			} else {
				result += min_pq2;
				pq2.poll();
			}

			hired++; // Increment the count of hired workers
		}

		return result; // Return the total minimum cost
	}

	/**
	 * Main method for testing the totalCost method.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		TotalCostToHireKWorkers solution = new TotalCostToHireKWorkers();
		int[] costs = { 17, 12, 10, 2, 7, 2, 11, 20, 8 };
		int k = 3;
		int candidates = 4;

		// Print input array
		System.out.print("An array represents the cost of hiring a worker: [ ");
		for (int cost : costs) {
			System.out.print(cost + " ");
		}
		System.out.println("]");

		// Print parameters
		System.out.println("Total number of workers to hire: " + k);
		System.out.println("Number of candidates to consider from each end at every step: " + candidates);

		// Calculate and print the result
		long result = solution.totalCost(costs, k, candidates);
		System.out.println("Minimum cost to hire " + k + " workers: " + result);
	}
}
