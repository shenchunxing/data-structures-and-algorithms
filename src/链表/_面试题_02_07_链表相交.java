package 链表;

import java.util.HashSet;
import java.util.Set;

import common.ListNode;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
 */
public class _面试题_02_07_链表相交 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) { //将headA的所有节点加入set
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) { //遍历headB的每个节点，如果发现重复了，直接返回
            if (set.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
