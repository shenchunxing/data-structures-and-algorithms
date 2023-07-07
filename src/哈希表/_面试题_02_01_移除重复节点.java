package 哈希表;

import java.util.HashSet;
import java.util.Set;

import common.ListNode;

/**
 * https://leetcode.cn/problems/remove-duplicate-node-lcci/
 */
/*2023-7-7*/
public class _面试题_02_01_移除重复节点 {
    public static void main(String[] args) {
       ListNode head = new ListNode(1);
       head.next = new ListNode(2);
       head.next.next = new ListNode(3);
       head.next.next.next = new ListNode(3);
       head.next.next.next.next = new ListNode(2);
       head.next.next.next.next.next = new ListNode(1);

       System.out.println(removeDuplicateNodes(head));
    }

    static public ListNode removeDuplicateNodes(ListNode head) {
        ListNode pre = null; /*记录上一个节点，为了在遇到重复的时候，可以删除重复节点*/
        ListNode cur = head;
        Set<Integer> set = new HashSet<>(); //查重
        while (cur != null) {
            if (set.contains(cur.val)) { //已经存在，删除当前值
                pre.next = cur.next;
            } else {
                set.add(cur.val); //第一次添加
                pre = cur; //重新记录上一个节点
            }
            cur = cur.next;
        }
        return head;
    }
}
