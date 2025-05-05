package Day5;

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

public class RemoveNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int count = 0;
		ListNode curr = head;

		while (curr != null) {
			curr = curr.next;
			count++;
		}
		
		if (count - n == 0) return head.next;
		curr = head;
        for (int i = 1; i < count - n; i++) {
            curr = curr.next;
        }

		curr.next = curr.next.next;

		return head;
	}

	public static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val);
			if (node.next != null)
				System.out.print(" -> ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		RemoveNodeFromEndOfList solution = new RemoveNodeFromEndOfList();

		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		int n = 4;

		System.out.print("Input: ");
		printList(head);
		
		ListNode result = solution.removeNthFromEnd(head, n);
		System.out.print("Output: ");
		printList(result);
	}
}
