package 链表;

import common.ListNode;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class _82_删除排序链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head; //head也可能被删
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int value = cur.next.val; //保留下,因为这一轮会被删
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
