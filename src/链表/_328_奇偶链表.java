package 链表;

import common.ListNode;

/**
 * https://leetcode.cn/problems/odd-even-linked-list/
 */
public class _328_奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        //奇数链表
        ListNode odd = head;
        //偶数链表
        ListNode even = head.next;
        //保留偶数链表头
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;//奇偶两个链表串起来
        return head;
    }
}
