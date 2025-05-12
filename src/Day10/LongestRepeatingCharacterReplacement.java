package Day10;

public class LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
		int[] freq = new int[26];
		int left = 0;
		int maxFreq = 0;
		int maxWindow = 0;

		for (int right = 0; right < s.length(); right++) {
			freq[s.charAt(right) - 'A']++;

			maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

			int windowLength = right - left + 1;

			if (windowLength - maxFreq > k) {
				freq[s.charAt(left) - 'A']--;
				left++;
			}

			windowLength = right - left + 1;
			maxWindow = Math.max(maxWindow, windowLength);
		}
		return maxWindow;
	}

	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();

		String s = "AABABBA";
		int k = 1;
		System.out.println("Input String: " + s);
		int result = solution.characterReplacement(s, k);
		System.out.println("No. of Characters required to replacement: " + result);
	}
}
