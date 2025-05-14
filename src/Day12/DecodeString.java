package Day12;

import java.util.Stack;

/**
 * This class provides a method to decode a given encoded string with the following pattern:
 * 
 * <p>k[encoded_string], where the encoded_string inside the square brackets is repeated exactly k times.
 * 
 * <p>Example:
 * <ul>
 *   <li>Input: "3[a]2[bc]"</li>
 *   <li>Output: "aaabcbc"</li>
 * </ul>
 */
public class DecodeString {

	/**
	 * Decodes the input string that follows the k[encoded_string] pattern.
	 * 
	 * <p>Supports nested patterns and multiple encodings.
	 * 
	 * @param s The encoded input string.
	 * @return The fully decoded string.
	 */
	public String decodeString(String s) {
		Stack<Integer> numStack = new Stack<>();
		Stack<String> strStack = new Stack<>();

		int currNum = 0;

		// Iterate through each character in the input string
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				// Build multi-digit numbers
				currNum = (currNum * 10) + (c - '0');
				continue;
			}

			if (c == '[') {
				// Push the current number and reset
				numStack.push(currNum);
				currNum = 0;
				strStack.push(String.valueOf(c));
				continue;
			}

			if (c != ']') {
				// Push regular characters
				strStack.push(String.valueOf(c));
				continue;
			}

			// When closing bracket is found, build the substring to repeat
			StringBuilder temp = new StringBuilder();
			while (!strStack.peek().equals("[")) {
				temp.insert(0, strStack.pop());
			}
			strStack.pop(); // Remove the '['

			// Repeat the substring
			StringBuilder replacement = new StringBuilder();
			int count = numStack.pop();
			for (int i = 0; i < count; i++) {
				replacement.append(temp);
			}

			// Push the repeated string back on the stack
			strStack.push(replacement.toString());
		}

		// Build the final result
		StringBuilder result = new StringBuilder();
		while (!strStack.empty()) {
			result.insert(0, strStack.pop());
		}
		return result.toString();
	}

	/**
	 * Main method to test the decoding functionality.
	 * 
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		DecodeString solution = new DecodeString();
		String s = "3[a]2[bc]";

		System.out.println("Input String: " + s);

		String result = solution.decodeString(s);
		System.out.println("Decoded String: " + result);
	}
}
