package 链表;

import common.ListNode;

/**
 * https://leetcode.cn/problems/reorder-list/
 */
public class _143_重排链表 {
    /**
     * 1 -> 2 -> 3 -> 4 -> 5
     * 1 -> 5 -> 2 -> 4 -> 3
     * 目标链表即为将原链表的左半端和反转后的右半端合并后的结果
     * @param head
     */
    //O(n) O(1)
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode mid = middleNode(head); //找到中间节点
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;//左半部分截断成l1
        l2 = reverseList(l2);//翻转右半部分，变成l2
        mergeList(l1,l2);//依次合并左右链表
    }

    /**
     * 找到链表中间节点
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 反转链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 合并链表:依次合并
     */
    public void mergeList(ListNode l1, ListNode l2) {
        ListNode temp1;
        ListNode temp2;
        while (l1 != null && l2 != null) {
            temp1 = l1.next;
            temp2 = l2.next;
            l1.next = l2;
            l1 = temp1;
            l2.next = l1;
            l2 = temp2;
        }
    }
}
