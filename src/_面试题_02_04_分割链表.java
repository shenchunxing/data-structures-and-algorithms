/**
 * https://leetcode.cn/problems/partition-list-lcci/
 */
public class _面试题_02_04_分割链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode small_dummy = new ListNode(0); //构建2个新链表
        ListNode big_dummy = new ListNode(0);
        ListNode small = small_dummy; //两个指针指向新链表的头节点
        ListNode big = big_dummy;
        while (head != null) {
            if (head.val >= x) {
                big.next = head;
                big = big.next;
            } else {
                small.next = head;
                small = small.next;
            }
            head = head.next;
        }
        small.next = big_dummy.next; //拼接到小的链表后面
        big.next = null;//大的链表最后清空
        return small_dummy.next;
    }
}
