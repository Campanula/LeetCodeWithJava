package algorithms;

import algorithms.model.ListNode;

/**
 * <h>Add Two Numbers</h>
 * <p>You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * <pre>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * </pre>
 */

public class AddTwoLinkedList {
    /**
     * 两条链表表示的非负数，从低位到高位节点对应相加
     * 递归方法，传递进位
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int overBit) { //recursive
        if (l1 == null && l2 == null) {
            return overBit == 0 ? null : new ListNode(overBit);
        }
        if (l1 != null && l2 != null) {
            int value = (l1.val + l2.val + overBit) % 10;
            overBit = (l1.val + l2.val + overBit) / 10;
            ListNode ln = new ListNode(value);
            ln.next = addTwoNumbers(l1.next, l2.next, overBit);
            return ln;
        } else {
            return overBit == 0 ? (l1 != null ? l1 : l2)
                    : addTwoNumbers((l1 != null ? l1 : l2), new ListNode(overBit), 0);
        }
    }

    /**
     * 非递归方法：
     * 使用链头，将两条链和一条进位链依次糅合为一条链
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) { //norecursive
        //链头
        ListNode dummyHead = new ListNode(0);
        //指针
        ListNode curr = dummyHead;
        int carry = 0;
        //糅合两条链 + 进位链：carry
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null) {
            curr.next = (carry == 0 ? null : new ListNode(carry));
            return dummyHead.next;
        }

        //剩下的一条链
        ListNode left = (l1 != null ? l1 : l2);
        //用另一个链头
        ListNode dummyHead2 = new ListNode(0);
        //另一个指针
        ListNode curr2 = dummyHead2;
        //糅合剩下的一条链 和 进位链：carry
        while (carry != 0 && left != null) {
            int sum = carry + left.val;
            carry = sum / 10;
            curr2.next = new ListNode(sum % 10);
            curr2 = curr2.next;
            left = left.next;
        }

        //链接剩下的节点
        curr2.next = (carry != 0 ? new ListNode(carry) : left);

        //将链接2和链接1相连
        curr.next = dummyHead2.next;
        return dummyHead.next;
    }
}
