package algorithms.model;

/**
 * 链表：
 * 当前节点，节点的值，下一个节点
 */

public class ListNode {

    public int val; // 当前节点的值

    public ListNode next; // 下一节点

    public ListNode(int x) {
        val = x;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    /**
     * 依次拼接当前节点和后续节点的值
     */
    @Override
    public String toString() {
        ListNode pointer = this;
        String num = String.valueOf(pointer.val);
        while (pointer.hasNext()) {
            pointer = pointer.next;
            num = pointer.val + num;
        }
        return num;
    }
}
