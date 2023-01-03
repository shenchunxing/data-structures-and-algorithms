import java.util.Stack;

/**
 * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class 剑指Offer06_从尾到头打印链表_栈 {
    //栈
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
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
