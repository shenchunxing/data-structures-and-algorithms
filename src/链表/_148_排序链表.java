package 链表;

import common.ListNode;

/**
 * https://leetcode.cn/problems/sort-list/
 * 难度：中等
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class _148_排序链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.println(sortList(head));
    }

    //分治+递归
    static public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)  return head;

        //先找到中间节点slow
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //截断分成2个链表
        ListNode tmp = slow.next;
        slow.next = null;

        //排序后的左链表
        ListNode left = sortList(head);
        //排序后的右链表
        ListNode right = sortList(tmp);

        //新链表头结点
        ListNode new_head = new ListNode(0);
        ListNode ans = new_head;
        //将两个链表节点比对大小，一个个串起来
        while (left != null && right != null) {
            if (left.val < right.val) {
                new_head.next = left;
                left = left.next;
            } else {
                new_head.next = right;
                right = right.next;
            }
            new_head = new_head.next;
        }
        //剩下的是left或者right，直接拼接到尾部
        new_head.next = left != null ? left : right;
        return ans.next;
    }
}
