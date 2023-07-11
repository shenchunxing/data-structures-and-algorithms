package 链表;

import common.ListNode;

/**
 * https://leetcode.cn/problems/delete-middle-node-lcci/
 */
/*2023-7-11*/
public class _面试题_02_03_删除中间节点 {
    public void deleteNode(ListNode node) {
        //复制node的后继节点给node
        node.val = node.next.val;
        //删除后继节点
        node.next = node.next.next;
    }
}
