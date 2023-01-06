package 链表;

import common.ListNode;

/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 */
public class _25_K个一组翻转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(reverseKGroup(head,2));
    }

    static public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode tail = head;//tail是尾巴节点
        for (int i = 0; i < k; i++) {
            if (tail == null) return head; //链表长度太短，不足以翻转
            tail = tail.next;
        }
        ListNode newHead = reverse(head,tail);//翻转前k个元素,不包括tail节点
        head.next = reverseKGroup(tail,k);//下一轮开始的地方就是tail
        return newHead;
    }

    //翻转指定区域的链表
    static private ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        while (head != tail) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
