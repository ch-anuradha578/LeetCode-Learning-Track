package Day7;

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

public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;

		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode second = reverse(slow.next);
		slow.next = null;

		ListNode first = head;
		while (second != null) {
			ListNode temp1 = first.next;
			ListNode temp2 = second.next;
			first.next = second;
			second.next = temp1;
			first = temp1;
			second = temp2;
		}
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

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

	public static void main(String[] args) {
		ReorderList solution = new ReorderList();
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		
		System.out.print("Input: ");
		printList(head);
		
		solution.reorderList(head);
		System.out.print("Output: ");
		printList(head);
	}
}
