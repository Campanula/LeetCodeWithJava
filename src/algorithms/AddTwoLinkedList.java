package algorithms;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * <pre>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * </pre>
 * 
 * @author Chaney
 */
public class AddTwoLinkedList {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null){
			return null;
		} else if (l1 != null && l2 != null) {
			int value = (l1.val + l2.val) % 10;
			int overbit = (l1.val + l2.val) / 10;
			ListNode ln = new ListNode(value);
			ListNode tmp = addTwoNumbers(l1.next, l2.next);
			ln.next = new ListNode((tmp == null ? 0 : tmp.val) + overbit);
			return ln;
		} else {
			return l1 != null ? l1 : l2;
		}
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
