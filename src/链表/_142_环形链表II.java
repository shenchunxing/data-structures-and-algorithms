package 链表;

import java.util.HashSet;
import java.util.Set;

import common.ListNode;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 * 难度：中等
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
/*2023-7-14*/
public class _142_环形链表II {
    public static void main(String[] args) {
        // 创建一个有循环的链表
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3; // 循环的入口节点是3

        // 调用detectCycle方法检测循环并返回入口节点
        ListNode result = detectCycle(head);

        if (result != null) {
            System.out.println("存在循环，循环的入口节点值为: " + result.val);
        } else {
            System.out.println("不存在循环");
        }
    }
    /**
     * 快慢指针 + 数学推导 O(n) O(1)
     * fast走的是slow的2倍路程 f = 2s
     * 同时fast比slow多走了n个环的长度 f = s + nb，s是slow指针走的长度，b是环的长度
     * 得到s = nb
     * 如果让指针从链表头部一直向前走并统计步数k那么所有 走到链表入口节点时的步数k = a + nb,a是从头走到环入口的长度
     * 因为第一次相遇的时候slow已经走了s = nb，因此slow再走a就能到达环的入口
     * 所以把fast从head开始走，每次变成走一步，走完a刚好可以和slow相遇
     */
   static public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null; //fast走完了整个链表，说明不存在环，返回false
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;//第一次在环内的某处相遇了.不一定刚好是入口位置
        }
        fast = head;//让fast重新指向head，此时如果第二次相遇，fast走到的位置刚好就是环的入口
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }



    /**
     * 哈希表：记录遍历过的每个节点，如果遇到了此前遍历过的节点，说明有环
     * O(n) O(n)
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode pos = head;
        Set<ListNode> set = new HashSet<>();
        while (pos != null) {
            if (set.contains(pos)) {
                return pos;
            } else {
                set.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }
}
