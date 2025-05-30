package Day22;

/**
 * Class representing a node in a singly linked list.
 */
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

/**
 * This class provides a method to reverse nodes in a linked list
 * in groups of k.
 */
public class ReverseNodesInKGroup {

	/**
	 * Reverses the nodes of a linked list k at a time and returns its modified list.
	 * Nodes that are not part of a complete k-group remain in the same order.
	 *
	 * @param head The head of the linked list.
	 * @param k    The size of groups to reverse.
	 * @return The head of the modified list after k-group reversal.
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1)
			return head;

		// Dummy node initialization
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode curr = dummy, next = dummy, prev = dummy;

		// Count total nodes
		int count = 0;
		while (curr.next != null) {
			curr = curr.next;
			count++;
		}

		// Reverse in groups of k
		while (count >= k) {
			curr = prev.next;
			next = curr.next;
			// Perform k-1 internal reversals
			for (int i = 1; i < k; i++) {
				curr.next = next.next;
				next.next = prev.next;
				prev.next = next;
				next = curr.next;
			}
			// Move prev pointer k nodes ahead
			prev = curr;
			count -= k;
		}

		return dummy.next;
	}

	/**
	 * Utility method to print a linked list from the given head node.
	 *
	 * @param head The head of the linked list.
	 */
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println("null");
	}

	/**
	 * Main method to demonstrate reversing nodes in k-groups.
	 *
	 * @param args Command line arguments (unused).
	 */
	public static void main(String[] args) {
		// Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		System.out.println("Original List:");
		printList(head);

		// Reverse in groups of k
		int k = 3;
		ReverseNodesInKGroup solution = new ReverseNodesInKGroup();
		ListNode newHead = solution.reverseKGroup(head, k);

		System.out.println("Reversed in groups of " + k + ":");
		printList(newHead);
	}
}
