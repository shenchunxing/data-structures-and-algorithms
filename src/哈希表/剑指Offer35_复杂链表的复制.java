package 哈希表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.ListNode;
import common.TreeNode;

/**
 * https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * 本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
/*2023-7-7*/
public class 剑指Offer35_复杂链表的复制 {

   static public class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

       /*打印链表*/
       public void printLinkedList() {
           Node current = this;
           while (current != null) {
               System.out.print(current.val + " -> ");
               current = current.next;
           }
           System.out.println("null");
       }
    }

    static public void main(String[] args) {
// 创建一个示例链表：1 -> 2 -> 3 -> null
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;

        // 设置 random 指针
        node1.random = node3;
        node2.random = node1;
        node3.random = node2;

        剑指Offer35_复杂链表的复制 obj = new 剑指Offer35_复杂链表的复制();
        // 调用深拷贝方法
        Node clonedList = obj.copyRandomList(node1);
        clonedList.printLinkedList();
    }

    HashMap<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        //如果已经存在，直接返回节点
        if (this.map.containsKey(head)) {
            return this.map.get(head);
        }
        //新建一个节点，拷贝链表的根节点
        Node node = new Node(head.val);
        this.map.put(head,node);//存入哈希表，防止多次拷贝以head为根节点的链表
        node.next = this.copyRandomList(head.next); //拷贝next节点
        node.random = this.copyRandomList(head.random);//拷贝random节点
        return node;
    }
}
