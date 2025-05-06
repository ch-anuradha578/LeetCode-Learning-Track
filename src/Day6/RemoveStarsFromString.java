package Day6;

import java.util.Stack;

public class RemoveStarsFromString {
	public String removeStars(String s) {
		Stack<Character> word = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != '*') {
				word.push(c);
			} else if (!word.isEmpty()) {
				word.pop();
			}
		}
		StringBuilder str = new StringBuilder();
		while (!word.isEmpty()) {
			str.append(word.pop());
		}
		return str.reverse().toString();
	}

	public static void main(String[] args) {
		RemoveStarsFromString solution = new RemoveStarsFromString();

		String s = "leet**cod*e";
		System.out.println("Input String: " + s);
		String result = solution.removeStars(s);
		System.out.println("Output String: " + result);
	}
}
