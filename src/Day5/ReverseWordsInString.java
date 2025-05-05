package Day5;

public class ReverseWordsInString {
	public String reverseWords(String s) {
		s = s.trim();
		String[] words = s.split("\\s+");
		StringBuilder reversedStr = new StringBuilder();

		for (int i = words.length - 1; i >= 0; i--) {
			reversedStr.append(words[i]);
			if (i != 0) {
				reversedStr.append(" ");
			}
		}
		return reversedStr.toString();
	}

	public static void main(String[] args) {
		ReverseWordsInString solution = new ReverseWordsInString();
		String s = "the sky is blue";

		String result = solution.reverseWords(s);

		System.out.println("Input String: " + s);
		System.out.println("Output String: " + result);
	}
}
