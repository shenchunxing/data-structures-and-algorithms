package 栈;

import java.util.Arrays;
import java.util.Stack;

import common.ListNode;

/**
 * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 难度：简单
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
 */
/*2023-7-10*/
public class 剑指Offer06_从尾到头打印链表 {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        System.out.println(Arrays.toString(reversePrint(root)));
    }
    //栈
   static public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        /*先全部入栈，再全部出栈即可*/
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = 0 ; i < size; i++) {
            ans[i] = stack.pop().val;
        }
        return ans;
    }
}
