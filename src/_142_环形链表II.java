import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 */
public class _142_环形链表II {
    /**
     * 快慢指针 + 数学推导 O(n) O(1)
     * fast走的是slow的2倍路程 f = 2s
     * fast比slow多走了n个环的长度 f = s + nb
     * 得到s = nb
     * 如果让指针从链表头部一直向前走并统计步数k那么所有 走到链表入口节点时的步数k = a + nb,
     * 因为第一次相遇的时候slow已经走了s = nb，因此slow再走a就能到达环的入口
     * 把fast从head开始走，每次变成走一步，走完a刚好可以和slow相遇
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null; //fast走完了整个链表，返回false
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;//第一次在环内的某处相遇了
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
