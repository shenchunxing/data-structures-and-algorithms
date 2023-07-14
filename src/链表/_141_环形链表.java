package 链表;

import common.ListNode;

/**
 * https://leetcode.cn/problems/linked-list-cycle/
 * 难度：简单
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 */
/*2023-7-14*/
public class _141_环形链表 {
    public static void main(String[] args) {
        // 创建一个有循环的链表
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3; // 循环的入口节点是3

        // 调用detectCycle方法检测循环并返回入口节点
        boolean result = hasCycle(head);
        System.out.println(result);
    }
    /*思路：快慢指针*/
    static public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true; //有环的话肯定会在某一处相遇
        }
        return false;
    }
}
