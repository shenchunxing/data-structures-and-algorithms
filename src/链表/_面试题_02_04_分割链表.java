package 链表;

import common.ListNode;

/**
 * https://leetcode.cn/problems/partition-list-lcci/
 * 难度：中等
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你不需要保留每个分区中各节点的初始相对位置。
 */
/*2023-7-11*/
public class _面试题_02_04_分割链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        System.out.println(partition(head,3));
    }

    static public ListNode partition(ListNode head, int x) {
        /*构建左右两个链表，分别存储小于x的节点和大于等于x的节点*/
        ListNode small_dummy = new ListNode(0);
        ListNode big_dummy = new ListNode(0);
        ListNode small = small_dummy; //两个指针指向新链表的头节点
        ListNode big = big_dummy;
        while (head != null) {
            if (head.val >= x) {
                big.next = head;
                big = big.next;
            } else {
                small.next = head;
                small = small.next;
            }
            head = head.next;
        }
        small.next = big_dummy.next; //拼接到小的链表后面
        big.next = null;//大的链表最后清空
        return small_dummy.next;
    }
}
