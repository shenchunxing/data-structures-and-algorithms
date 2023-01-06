package 链表;

import common.ListNode;

/**
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class 剑指Offer22_链表中倒数第k个节点 {
    //快慢指针
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        //fast首先到达和slow差距为k的位置
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        //fast走完，则slow刚好达到倒数k的位置
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
