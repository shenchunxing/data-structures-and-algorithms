package 链表;

import common.ListNode;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 * 难度：中等
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
/*2023-7-14*/
public class _82_删除排序链表中的重复元素II {
    public static void main(String[] args) {
        // 创建一个有循环的链表
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

       System.out.println(deleteDuplicates(head));
    }

    static public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        /*因为head也可能被删除，设置dummy.next = head，确保链表一直存在*/
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            /*如果当前节点和下一个节点是相同的，一起删除*/
            if (cur.next.val == cur.next.next.val) {
                /*需要保留当前被删除的节点值，以便和后续的节点比较*/
                int value = cur.next.val;
                /*循环删除：可能存在不止2个的连续相同的数，需要继续比较删除*/
                while (cur.next != null && value == cur.next.val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
