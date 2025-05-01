package Day3;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode prev = null;
		while (slow != null) {
			ListNode temp = slow.next;
			slow.next = prev;
			prev = slow;
			slow = temp;
		}
		while (prev != null) {
			if (head.val != prev.val)
				return false;
			head = head.next;
			prev = prev.next;
		}
		return true;
	}

	public static void printList(ListNode head) {
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.val + (curr.next != null ? " -> " : ""));
			curr = curr.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		PalindromeLinkedList solution = new PalindromeLinkedList();
		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));

		System.out.print("l1: ");
		printList(l1);

		boolean result = solution.isPalindrome(l1);
		System.out.println("Result: " + result);
	}

}
