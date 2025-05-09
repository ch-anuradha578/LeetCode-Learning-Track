package Day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<>();

		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] c = str.toCharArray();
			Arrays.sort(c);
			String key = new String(c);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(str);
		}

		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		GroupAnagrams solution = new GroupAnagrams();
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

		System.out.print("Input: [ ");
		for (String str : strs) {
			System.out.print(str + ", ");
		}
		System.out.println("]");

		List<List<String>> results = solution.groupAnagrams(strs);
		System.out.print("Output: ");
		for (List<String> result : results) {
			System.out.print(result + ", ");
		}
		System.out.println();
	}
	
}

