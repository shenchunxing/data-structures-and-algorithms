package 链表;

import common.ListNode;

/**
 * https://leetcode.cn/problems/odd-even-linked-list/
 * 给定单链表的头节点head，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为偶数 ，以此类推。
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * 你必须在O(1)的额外空间复杂度和O(n)的时间复杂度下解决这个问题。
 */
/*2023-7-6*/
public class _328_奇偶链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = oddEvenList(head);
        result.printLinkedList();
    }

    static public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        //奇数链表
        ListNode odd = head;
        //偶数链表
        ListNode even = head.next;
        //保留偶数链表头
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            /*奇数串起来*/
            odd.next = even.next;
            /*移动到下一个奇数*/
            odd = odd.next;
            /*偶数串起来*/
            even.next = odd.next;
            /*移动到下一个偶数*/
            even = even.next;
        }
        odd.next = evenHead;//奇偶两个链表串起来
        return head;
    }
}
