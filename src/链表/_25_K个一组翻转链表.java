package 链表;

import common.ListNode;

/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * 难度：困难
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
/*2023-7-14*/
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
        ListNode tail = head;//tail是指向尾部节点的指针
        /*让tail指向从head出发，走了k步的节点，注意因为tail是从head出发的，实际上tail走到的是下一次翻转的头节点位置*/
        for (int i = 0; i < k; i++) {
            if (tail == null) return head; //还没走到k就走完了链表，说明链表长度太短，不足以翻转
            tail = tail.next;
        }
        //翻转前k个元素,不包括tail节点
        /*进行了一次反转，得到新链表的头结点newHead。*/
        ListNode newHead = reverse(head,tail);
        /*目前head的next应该指向以tail节点为根节点的链表了，注意这里不能直接head.next = tail，因为这是一个递归过程，会执行多次翻转*/
        head.next = reverseKGroup(tail,k);
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
