package 链表;

import common.ListNode;

/**
 * https://leetcode.cn/problems/delete-node-in-a-linked-list/
 */
/*2023-7-6*/
public class _237_删除链表中的节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        deleteNode(head.next);
        head.printLinkedList();
    }

    /*思路：先把node.next.val覆盖给node节点，然后删除node.next*/
   static public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
