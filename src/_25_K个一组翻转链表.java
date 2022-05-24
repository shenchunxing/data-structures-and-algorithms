/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 */
public class _25_K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            //因为tail一直在遍历，如果为空了，说明没有到达k长度，就结束了，剩余的节点太少不足翻转链表
            if (tail == null) return head;
            tail = tail.next;
        }
        //翻转前k个元素
        ListNode newHead = reverse(head,tail);
        //下一轮开始的地方就是tail
        head.next = reverseKGroup(tail,k);
        return newHead;
    }

    /**
     * 翻转指定位置的链表
     */
    private ListNode reverse(ListNode head , ListNode tail) {
        ListNode prev = null;
        ListNode temp = null;
        while (head != tail) { //head != tail
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
