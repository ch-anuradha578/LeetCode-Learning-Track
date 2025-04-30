package Day1;

import java.util.HashMap;

public class FindLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int maxLen = 0;
		int start = -1;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (map.containsKey(c) && map.get(c) > start) {
				start = map.get(c);
			}
			map.put(c, i);
			maxLen = Math.max(maxLen, i - start);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		FindLongestSubstring solution = new FindLongestSubstring();
		String input = "abcabcbb";
		int result = solution.lengthOfLongestSubstring(input);
		System.out.println("Input: " + input);
		System.out.println("Length of longest substring without repeating characters: " + result);
	}
}
