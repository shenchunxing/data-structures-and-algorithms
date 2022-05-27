import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 */
public class _142_环形链表II {
    /**
     * 同下面的方法detectCycle1，但是不知道为什么下面的超时了
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    /**
     * 快慢指针 + 数学推导 O(n) O(1)
     * 环外长度为a，环的长度是b+c，相遇的时候slow走了a + b，此时fast走了a + n *(b + c) +b
     * 又因为fast走的距离是slow的两倍则a(a + b) = a + n *(b + c) +b
     * 则 a = c + (n - 1)(b + c)
     * 我们会发现：从相遇点b到入环点的距离加上n−1 圈的环长，恰好等于从链表头部到入环点的距离a。
     * 因此，当slow和fast相遇，让额外的pre从链表头开始，同时slow从相遇点开始，则最终会在环的入口位置相遇
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null) return head;
        ListNode slow = head , fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null; //没有环
            }
            if (fast == slow) { //相遇了，有环
                ListNode pre = head;
                while (pre != slow) { //从相遇位置开始，最终会和从链表头开始的pre相遇在环的入口
                    pre = pre.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
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
