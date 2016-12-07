package algorithms.test;


import algorithms.AddTwoLinkedList;
import algorithms.model.ListNode;

public class AddTwoLinkedListTest {
    public static void main(String args[]) {
        AddTwoLinkedList test = new AddTwoLinkedList();
        System.out.println(test.addTwoNumbers(num2node(99999), num2node(1)));
    }

    static ListNode num2node(int num) {
        if (num > 9) {
            ListNode node = new ListNode(num % 10);
            node.next = num2node(num / 10);
            return node;
        }
        return new ListNode(num);
    }
}
