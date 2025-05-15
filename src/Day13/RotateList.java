package Day13;

/**
 * This class represents a node in a singly linked list.
 */
class ListNode {
	int val;
	ListNode next;

	/**
	 * Constructor to create a node with default values.
	 */
	ListNode() {
	}

	/**
	 * Constructor to create a node with a value.
	 * 
	 * @param val The value of the node.
	 */
	ListNode(int val) {
		this.val = val;
	}

	/**
	 * Constructor to create a node with a value and next reference.
	 * 
	 * @param val  The value of the node
	 * @param next The next node in the list.
	 */
	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

/**
 * This class has a method to rotate a linked list to the right by a given
 * number of positions.
 */
public class RotateList {

	/**
	 * Rotates the linked list to the right by k places.
	 *
	 * @param head The first node (head) of the linked list
	 * @param k    How many times you want to rotate the list
	 * @return The new head node after rotating
	 */
	public ListNode rotateRight(ListNode head, int k) {
		// If the list is empty, has only one node, or k is 0, return head
		if (head == null || head.next == null || k == 0)
			return head;

		// Count the number of nodes in the list
		int len = 1;
		ListNode temp = head;
		while (temp.next != null) {
			len++;
			temp = temp.next;
		}

		// Connect the end of the list to the head to make it circular
		temp.next = head;

		// Find the effective number of rotations (in case k > length)
		k = k % len;
		int gap = len - k;

		// Move to the new tail
		ListNode curr = head;
		while (--gap > 0) {
			curr = curr.next;
		}

		// Set the new head and break the circle
		head = curr.next;
		curr.next = null;

		return head;
	}

	/**
	 * A helper method to print all values in the linked list.
	 * 
	 * @param head The first node of the list
	 */
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val);
			if (head.next != null) {
				System.out.print(" -> ");
			}
			head = head.next;
		}
		System.out.println();
	}

	/**
	 * Main method to test the rotateRight function with sample data.
	 * 
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		RotateList solution = new RotateList();

		// Creating a list: 1 -> 2 -> 3 -> 4 -> 5
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

		int k = 2; // Number of positions to rotate the list

		System.out.print("Input: ");
		printList(head);

		System.out.println("No. of Positions to rotate the list: " + k);

		ListNode result = new ListNode();

		System.out.print("Output: ");
		result = solution.rotateRight(head, k);
		printList(result);
	}
}
