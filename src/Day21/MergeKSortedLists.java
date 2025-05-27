package Day21;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Class to merge k sorted linked lists into a single sorted linked list.
 */
public class MergeKSortedLists {

	/**
	 * Merges k sorted linked lists using a min-heap (priority queue). Time O(N log
	 * k) Complexity, where N is the total number of nodes across all lists.
	 *
	 * @param lists Array of ListNode representing the heads of k sorted linked
	 *              lists.
	 * @return The head of the merged sorted linked list.
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = new ListNode(0);
		Queue<ListNode> minHeap = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);

		// Add all non-null list heads to the minHeap
		for (ListNode node : lists) {
			if (node != null) {
				minHeap.add(node);
			}
		}

		ListNode curr = head;
		// Extract the smallest node from the heap and add the next node from the same list
		while (!minHeap.isEmpty()) {
			ListNode temp = minHeap.poll();
			if (temp.next != null) {
				minHeap.add(temp.next);
			}
			curr.next = temp;
			curr = curr.next;
		}

		return head.next;
	}

	/**
	 * Helper method to print a linked list.
	 *
	 * @param head The head node of the list to be printed.
	 */
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	/**
	 * Main method to test the mergeKLists function.
	 */
	public static void main(String[] args) {
		MergeKSortedLists solution = new MergeKSortedLists();

		// Create test data: 3 sorted linked lists
		ListNode[] lists = new ListNode[3];
		lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
		lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
		lists[2] = new ListNode(2, new ListNode(6));
		
		System.out.println("Input lists:");
	    for (int i = 0; i < lists.length; i++) {
	        System.out.print("List " + (i + 1) + ": ");
	        printList(lists[i]);
	    }

		// Merge and print the result
		ListNode merged = solution.mergeKLists(lists);
		System.out.print("Merged list: ");
		printList(merged); 
	}
}
