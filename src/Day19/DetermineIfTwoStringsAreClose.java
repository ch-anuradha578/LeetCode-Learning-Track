package Day19;

import java.util.Arrays;

/**
 * This class checks whether two strings are "close".
 */
public class DetermineIfTwoStringsAreClose {

	/**
	 * Determines whether two strings are close based on character frequency and
	 * character set.
	 *
	 * @param word1 First input string.
	 * @param word2 Second input string.
	 * @return true if the strings are close, otherwise false.
	 */
	public boolean closeStrings(String word1, String word2) {
		// If lengths don't match, they can't be close
		if (word1.length() != word2.length())
			return false;

		int[] freq1 = new int[26]; // Frequency array for word1
		int[] freq2 = new int[26]; // Frequency array for word2

		// Count character frequencies
		for (int i = 0; i < word1.length(); i++) {
			freq1[word1.charAt(i) - 'a']++;
			freq2[word2.charAt(i) - 'a']++;
		}

		// Check if both strings contain the same set of characters
		for (int i = 0; i < 26; i++) {
			if ((freq1[i] == 0) != (freq2[i] == 0)) {
				return false; // One string has a character the other doesn't
			}
		}

		//Sort the frequencies
		Arrays.sort(freq1);
		Arrays.sort(freq2);

		//Return whether the frequency distributions match
		return Arrays.equals(freq1, freq2);
	}

	/**
	 * Main method to test the closeStrings method.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		DetermineIfTwoStringsAreClose solution = new DetermineIfTwoStringsAreClose();

		String word1 = "cabbba";
		String word2 = "abbccc";

		// Print the input strings
		System.out.println("Given Word1: " + word1);
		System.out.println("Given Word2: " + word2);

		// Determine and print if the strings are close
		boolean result = solution.closeStrings(word1, word2);
		System.out.println("Are the two strings close?: " + result);
	}
}
