package algorithms.model;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public String toString() {
        String num = "" + this.val;
        ListNode pointer = this;
        while (pointer.hasNext()) {
            pointer = pointer.next;
            num = pointer.val + num;
        }
        return num;
    }
}
