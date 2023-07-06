package 链表;

import common.ListNode;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 */
/*2023-7-6*/
public class _83_删除排序链表中的重复元素 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(4);

        ListNode result = deleteDuplicates(head);
        result.printLinkedList();
    }
    static public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        /*cur != null && cur.next != null 这种写法是为了适应节点数量是奇数和偶数*/
        while (cur != null && cur.next != null) {
            /*如果相同，直接跳过下一个节点*/
            if (cur.val == cur.next.val) {
                /*这里因为cur.next != null，cur.next.next即使==null也没问题，就是删除的是链表的最后一个节点*/
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
