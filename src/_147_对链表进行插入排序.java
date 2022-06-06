import javax.swing.*;
import java.util.List;

/**
 * https://leetcode.cn/problems/insertion-sort-list/
 */
public class _147_对链表进行插入排序 {
    //O(n^2) O(1)
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastSorted = head;//排序后的最后一个节点
        ListNode cur = head.next; //当前待插入的节点
        while (cur != null) {
            if (lastSorted.val <= cur.val) { //当前节点大于最后一个已排序的节点
                lastSorted = lastSorted.next; //更新最后一个排序节点
            } else {
                //从链表头开始扫描，找到待插入的位置
                ListNode prev = dummy;
                while (prev.next.val <= cur.val) {
                    prev = prev.next;
                }
                lastSorted.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
            }
            cur = lastSorted.next; //继续扫描
        }
        return dummy.next;
    }
}
