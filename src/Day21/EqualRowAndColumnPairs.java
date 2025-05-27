package Day21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Class to count the number of pairs (r, c) where the rth row and cth column
 * in a square grid are identical.
 */
public class EqualRowAndColumnPairs {

	/**
	 * Counts how many rows match exactly with columns in a square grid.
	 *
	 * @param grid 2D square integer array (n x n)
	 * @return Number of row-column pairs that are equal
	 */
	public int equalPairs(int[][] grid) {
		int n = grid.length;
		int count = 0;

		// Stores frequency of each row as a string
		Map<String, Integer> rowCounter = new HashMap<>();

		// Convert each row to string and count occurrences
		for (int[] row : grid) {
			String rowString = Arrays.toString(row);
			rowCounter.put(rowString, rowCounter.getOrDefault(rowString, 0) + 1);
		}

		// Iterate through each column
		for (int c = 0; c < n; c++) {
			int[] columnArray = new int[n];

			// Extract column values
			for (int r = 0; r < n; r++) {
				columnArray[r] = grid[r][c];
			}

			// Convert column to string and check for match in row map
			String columnString = Arrays.toString(columnArray);
			count += rowCounter.getOrDefault(columnString, 0);
		}

		return count;
	}

	/**
	 * Helper method to print a 2D grid.
	 */
	public static void printGrid(int[][] grid) {
		for (int[] row : grid) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Sample test method to demonstrate functionality of equalPairs.
	 */
	public static void main(String[] args) {
		EqualRowAndColumnPairs solution = new EqualRowAndColumnPairs();

		int[][] grid = { { 3, 1, 2, 2 }, { 1, 4, 4, 5 }, { 2, 4, 2, 2 }, { 2, 4, 2, 2 } };

		System.out.println("Input grid:");
		printGrid(grid);
		int result = solution.equalPairs(grid);
		System.out.println("Equal row-column pairs: " + result);
	}
}
