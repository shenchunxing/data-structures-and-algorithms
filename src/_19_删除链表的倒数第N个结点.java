
/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class _19_删除链表的倒数第N个结点 {
	//利用快慢指针，第一个指针指向n+1的位置，第二个指针从头开始
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy = new ListNode(0); //哨兵
       dummy.next = head;
       ListNode fast = dummy;
       ListNode slow = dummy;
       //快指针到n+1的位置
       for (int i = 1;i<= n+1;i++) {
           fast = fast.next;
       }
       
       //快指针到结束，慢指针指向删除的节点
       while (fast != null) {
           fast = fast.next;
           slow = slow.next;
       }
       
       //删除节点
       slow.next = slow.next.next;
       return dummy.next;
    }
}
