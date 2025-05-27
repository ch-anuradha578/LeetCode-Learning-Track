package Day21;

/**
 * Definition for singly-linked list node.
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
 * This class contains a method to reorder a linked list such that all the
 * odd-indexed nodes are grouped together followed by even-indexed nodes.
 */
public class OddEvenLinkedList {

	/**
	 * Rearranges the linked list nodes such that nodes at odd indices come first,
	 * followed by nodes at even indices. Indexing is 1-based.
	 *
	 * @param head The head of the singly linked list
	 * @return The head of the reordered linked list
	 */
	public ListNode oddEvenList(ListNode head) {
		if (head == null)
			return head;

		// Initialize pointers for odd and even nodes
		ListNode odd = head; 
		ListNode even = head.next; 
		ListNode evenHead = even; 

		// Rearrange nodes until we reach the end of the list
		while (even != null && even.next != null) {
			odd.next = odd.next.next; 
			odd = odd.next;

			even.next = even.next.next;
			even = even.next; 
		}

		// Attach even nodes after all odd nodes
		odd.next = evenHead;
		return head;
	}

	/**
	 * Utility method to print the linked list in a readable format.
	 *
	 * @param head The head of the linked list to print
	 */
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + (head.next != null ? " -> " : ""));
			head = head.next;
		}
		System.out.println();
	}

	/**
	 * Main method to test the oddEvenList functionality with sample data.
	 */
	public static void main(String[] args) {
		OddEvenLinkedList solution = new OddEvenLinkedList();

		// Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

		System.out.print("Input Head: ");
		printList(head);

		// Perform odd-even reordering
		ListNode result = solution.oddEvenList(head);

		System.out.print("Odd Even Linked List: ");
		printList(result);
	}
}
