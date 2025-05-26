package Day20;

import java.util.Arrays;

/**
 * Solves the "Successful Pairs of Spells and Potions" problem. For each spell,
 * counts how many potions form a successful pair where spell * potion ≥
 * success.
 */
public class SuccessfulPairsOfSpellsAndPotions {

	/**
	 * Calculates the number of successful pairs for each spell.
	 *
	 * @param spells  Array of spell strengths.
	 * @param potions Array of potion strengths.
	 * @param success Minimum product required for a successful pair.
	 * @return Array of counts of successful pairs per spell.
	 */
	public int[] successfulPairs(int[] spells, int[] potions, long success) {
		Arrays.sort(potions); // Sort potions for binary search
		int[] pairs = new int[spells.length];

		for (int i = 0; i < spells.length; i++) {
			long minPotion = (success + spells[i] - 1) / spells[i]; // Ceil(success / spell)
			pairs[i] = potions.length - binarySearch(potions, minPotion); // Count potions ≥ minPotion
		}

		return pairs;
	}

	/**
	 * Finds the first index in potions where potion ≥ key using binary search.
	 *
	 * @param potions Sorted array of potions.
	 * @param key     Minimum potion strength needed.
	 * @return Index of the first potion ≥ key.
	 */
	private int binarySearch(int[] potions, long key) {
		int low = 0, high = potions.length;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (potions[mid] < key) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	/**
	 * Main method to test the successfulPairs method with sample input.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		SuccessfulPairsOfSpellsAndPotions solution = new SuccessfulPairsOfSpellsAndPotions();

		int[] spells = { 5,1,3 };
		int[] potions = { 1, 2, 3, 4, 5 };
		long success = 7;

		// Print input spells
		System.out.print("Spells: [ ");
		for (int spell : spells) {
			System.out.print(spell + " ");
		}
		System.out.println("]");

		// Print input potions
		System.out.print("Potions: [ ");
		for (int potion : potions) {
			System.out.print(potion + " ");
		}
		System.out.println("]");

		// Print success
		System.out.println("Success: " + success);

		int[] result = solution.successfulPairs(spells, potions, success);

		System.out.print("Successful Pairs: [ ");
		for (int count : result) {
			System.out.print(count + " ");
		}
		System.out.println("]");
	}

}
