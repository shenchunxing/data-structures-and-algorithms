/**
 * https://leetcode.cn/problems/sort-list/
 */
public class _148_排序链表 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)  return head;

        //中间节点slow
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //截断
        ListNode tmp = slow.next;
        slow.next = null;

        //排序后的左链表
        ListNode left = sortList(head);
        //排序后的右链表
        ListNode right = sortList(tmp);

        //新链表头结点
        ListNode h = new ListNode(0);
        ListNode res = h;
        //一个个串起来
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
}
