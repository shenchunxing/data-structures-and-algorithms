package 链表;

import common.ListNode;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置
 */
public class _61_旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) return head;
        if (head == null || head.next == null) return head;
        int len = 1; //链表长度
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        tail.next = head; //首尾相连
        int step = len - k % len; //可能k>n，需要取摸
        while (step > 0) {
            tail = tail.next;
            step--;
        }
        //tail在新链表的尾节点
        ListNode ans = tail.next;
        tail.next = null;//断开首尾相连
        return ans;
    }
}
