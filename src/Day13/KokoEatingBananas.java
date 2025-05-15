package Day13;

/**
 * This class helps to find the minimum speed at which Koko can eat all the bananas
 * within a given number of hours using binary search method.
 */
public class KokoEatingBananas {

	/**
	 * Finds the minimum eating speed that allows Koko to finish all the banana piles
	 * within 'h' hours.
	 *
	 * @param piles An array where each element represents the number of bananas in a pile
	 * @param h The number of hours Koko has to eat all the bananas
	 * @return The smallest integer speed (bananas per hour) that lets Koko finish in time
	 */
	public int minEatingSpeed(int[] piles, int h) {
		int minSpeed = 1;
		int maxSpeed = 0;

		// Find the maximum pile size
		for (int pile : piles)
			maxSpeed = Math.max(maxSpeed, pile);

		// Use binary search to find the smallest valid speed
		while (minSpeed < maxSpeed) {
			int mid = minSpeed + (maxSpeed - minSpeed) / 2;

			// Check if Koko can finish eating at this speed
			if (canEatInTime(piles, h, mid))
				maxSpeed = mid; // Try a slower speed
			else
				minSpeed = mid + 1; // Need a faster speed
		}
		return minSpeed;
	}

	/**
	 * Helper method that checks if Koko can finish all bananas at a given speed within h hours.
	 *
	 * @param piles Array of banana piles
	 * @param h Total hours available
	 * @param speed Eating speed to test
	 * @return true if Koko can finish in time, false otherwise
	 */
	private boolean canEatInTime(int[] piles, int h, int speed) {
		int hours = 0;

		// Calculate total hours required at the current speed
		for (int pile : piles)
			hours += (int) Math.ceil((double) pile / speed);

		// Return true if the required time is within the allowed time
		return hours <= h;
	}

	/**
	 * Main method to test the solution with example input.
	 * @param args Command-line arguments 
	 */
	public static void main(String[] args) {
		KokoEatingBananas solution = new KokoEatingBananas();
		int[] piles = { 3, 6, 7, 11 };
		int h = 8;

		System.out.print("Piles: [ ");
		for (int pile : piles) {
			System.out.print(pile + " ");
		}
		System.out.println("]");

		System.out.println("Hours Available: " + h);
		int result = solution.minEatingSpeed(piles, h);
		System.out.println("Minimum speed in which Koko can eat bananas: " + result);
	}
}
