import javax.swing.*;
import java.util.List;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置
 */
public class _61_旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) return head;
        if (head == null || head.next == null) return head;
        //计算链表的长度
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        //iter现在在链表的尾节点
        int add = n - k % n;
        //让链表的尾节点和头节点相连
        iter.next = head;
        while (add -- > 0) {
            iter = iter.next;
        }
        //iter现在到达了新链表的尾节点，
        ListNode ret = iter.next;
        iter.next = null;//截断
        return ret;
    }
}
