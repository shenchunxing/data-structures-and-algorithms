package 链表;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
/*2023-7-4*/
public class _19_删除链表的倒数第N个结点 {
    public static void main(String[] args) {
// 创建测试链表: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2; // 删除倒数第N个节点

        ListNode result = removeNthFromEnd(head, n);

        // 打印链表结果
        ListNode node = result;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

	//利用快慢指针，第一个指针指向n+1的位置，第二个指针从头开始
    static public ListNode removeNthFromEnd(ListNode head, int n) {
        /*用一个哨兵节点连接链表，防止被删除的刚好是根节点*/
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       ListNode fast = dummy;
       ListNode slow = dummy;
        for (int i = 0; i <= n; i++) { //快指针先走到第n个节点处
            fast = fast.next;
        }
        while (fast != null) {//快指针走完剩下的链表长度,慢指针所处的位置就是需要删除的节点位置，删除
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
