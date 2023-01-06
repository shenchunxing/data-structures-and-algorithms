package 链表;

import common.ListNode;

/**
 * https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class 剑指Offer18_删除链表的节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(4);

        System.out.println(deleteNode(head,3));
    }

   static public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0); //设置虚拟头节点
        dummy.next = head;//连上head，成为新链表的头节点
        ListNode cur = dummy;//指针从头节点开始遍历
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteNode1(ListNode head, int val) {
       if (head.val == val) return head.next;
       //pre指向前一个节点，cur指向当前节点
       ListNode pre = head,cur = head.next;
       //跳过非val节点。遍历完了，也要结束循环
       while (cur != null && cur.val != val) {
           pre = cur;
           cur = cur.next;
       }
       //遇到了val节点，可能遍历完了也没有val节点。需要判断
       if (cur != null) {
           pre.next = cur.next;
       }
       return head;
    }

    public ListNode deleteNode2(ListNode head, int val) {
        ListNode temp = head;//因为head会变化，需要一个指针引用住head
        if (head.val == val) return head.next; //如果开头就是val，直接取下一个
        while (head.next.val != val) { //遍历节点，直到遇到val
            head = head.next;
        }
        head.next = head.next.next;//遇到val，直接跳过
        return temp;
    }

    //mj头尾节点
    public ListNode deleteNode3(ListNode head, int val) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0); //哨兵头节点
        ListNode newTail = newHead; //尾节点
        while (head != null) {
            if (head.val != val) {
                newTail.next = head;
                newTail = head;
            }
            head = head.next;
        }
        newTail.next = null;//尾节点置null
        return newHead.next;
    }
}
