package 链表;

import common.ListNode;

/**
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 */
/*2023-7-6*/
public class _876_链表的中间结点 {
    public static void main(String[] args) {
        // 创建测试链表1: 1 -> 2 -> 3 -> 4  链表节点为奇数也是符合的
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode result = middleNode(l1);

        // 打印合并后的链表结果
        ListNode node = result;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
    static public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        /*fast != null && fast.next != null 这个条件表示链表节点为偶数，最后fast = null,链表节点为奇数，最后fast!= null && fast.next = null*/
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
