package 链表;

import java.util.HashSet;
import java.util.Set;

import common.ListNode;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
 * 难度：简单
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须保持其原始结构 。
 */
/*2023-7-11*/
public class _面试题_02_07_链表相交 {
    public static void main(String[] args) {

        /*注意：这里的链表相交只适合相交节点是公用的，而不是只是值相同但是节点分开创建的情况*/
        ListNode commonNode =  new ListNode(8);
        commonNode.next = new ListNode(4);
        commonNode.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = commonNode;

        System.out.println(getIntersectionNode(headA,headB));
    }

    /*双指针: 让pA和pB各自走完两个链表，这样可以保证即使两个链表长度不一致，但是指针走的步数是一致的，如果遇到相同的节点，必然是同步的*/
   static public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        /*还没遇到就继续遍历，最终是遇到 或者 遍历完链表了，返回null*/
        while (pA != pB) {
            /*自己的链表遍历结束，就去遍历对方的链表*/
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    /*哈希表*/
    static public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) { //将headA的所有节点加入set
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) { //遍历headB的每个节点，如果发现重复了，直接返回重复节点
            if (set.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
