package Day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class provides a method to generate all possible letter combinations
 * that a given digit string could represent on a traditional telephone keypad.
 * 
 * <p>For example, the digit '2' corresponds to the letters "abc", '3' to "def", and so on.
 */
public class LetterCombinationsofPhoneNumber {

	/**
	 * Given a string containing digits from 2 to 9, returns all possible letter
	 * combinations that the number could represent using the mapping of digits to
	 * letters on a phone keypad.
	 * 
	 * @param digits A string containing digits from 2 to 9.
	 * @return A list of all possible letter combinations.
	 */
	public List<String> letterCombinations(String digits) {
		List<String> resultList = new ArrayList<>();
		if (digits.length() == 0)
			return resultList;

		HashMap<Character, String> hm = new HashMap<>();
		hm.put('2', "abc");
		hm.put('3', "def");
		hm.put('4', "ghi");
		hm.put('5', "jkl");
		hm.put('6', "mno");
		hm.put('7', "pqrs");
		hm.put('8', "tuv");
		hm.put('9', "wxyz");

		backtrack(digits, 0, hm, new StringBuilder(), resultList);
		return resultList;
	}

	/**
	 * A helper method that uses backtracking to build all possible combinations of
	 * letters from the given digits.
	 * 
	 * @param digits      The input string of digits.
	 * @param i           The current index in the digit string.
	 * @param hm          A map from digits to their corresponding letters.
	 * @param sb          A StringBuilder used to build the current combination.
	 * @param resultList  A list that accumulates all valid combinations.
	 */
	private static void backtrack(String digits, int i, HashMap<Character, String> hm, StringBuilder sb,
			List<String> resultList) {
		if (i == digits.length()) {
			resultList.add(sb.toString());
			return;
		}

		String curr = hm.get(digits.charAt(i));
		for (int k = 0; k < curr.length(); k++) {
			sb.append(curr.charAt(k));
			backtrack(digits, i + 1, hm, sb, resultList);
			sb.deleteCharAt(sb.length() - 1); // backtrack
		}
	}

	/**
	 * Main method for testing the letter combination generator.
	 * 
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		LetterCombinationsofPhoneNumber solution = new LetterCombinationsofPhoneNumber();
		String digits = "23";

		System.out.println("Input String: " + digits);

		List<String> result = solution.letterCombinations(digits);
		System.out.println("Letter Combinations: " + result);
	}
}
