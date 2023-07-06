package 链表;

import common.ListNode;

/**
 * https://leetcode.cn/problems/rotate-list/
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置
 */
/*2023-7-6*/
public class _61_旋转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = rotateRight(head, 2);
        result.printLinkedList();
    }

   static public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) return head;
        if (head == null || head.next == null) return head;
        int len = 1; //链表长度

       /*首先将tail指针指向链表的尾部节点，并计算链表的总长度*/
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        /*首尾相连，现在是一个环形链表*/
        tail.next = head;
        /*计算需要让tail指针移动的步数，可能k>n，需要取摸。注意走的步数是总长度 - k的取模，并不是k，因为最后停下的位置是新链表的尾结点*/
        int step = len - k % len;
        while (step > 0) {
            tail = tail.next;
            step--;
        }
        //tail在新链表的尾节点，所以tail.next就是新链表的头结点
       /*保留头结点，然后断开首尾相连*/
        ListNode ans = tail.next;
        tail.next = null;
        return ans;
    }
}
