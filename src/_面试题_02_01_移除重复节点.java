import javax.swing.*;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

/**
 * https://leetcode.cn/problems/remove-duplicate-node-lcci/
 */
public class _面试题_02_01_移除重复节点 {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode pre = null; //重复节点的上一个节点
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
