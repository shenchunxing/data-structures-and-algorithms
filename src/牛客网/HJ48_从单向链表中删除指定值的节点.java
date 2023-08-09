package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/4
 * 输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
 * 构造过程，例如输入一行数据为:
 * 6 2 1 2 3 2 5 1 4 5 7 2 2
 * 则第一个参数6表示输入总共6个节点，第二个参数2表示头节点值为2，剩下的2个一组表示第2个节点值后面插入第1个节点值，为以下表示:
 * 1 2 表示为
 * 2->1
 * 链表为2->1
 *
 * 3 2表示为
 * 2->3
 * 链表为2->3->1
 *
 * 5 1表示为
 * 1->5
 * 链表为2->3->1->5
 *
 * 链表的值不能重复。
 */
public class HJ48_从单向链表中删除指定值的节点 {
    /*构建一个链表*/
    public static class Node {
        Node next;
        int val;
        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            String[] str = s.split(" ");
            /*节点个数*/
            int n = Integer.parseInt(str[0]);
            /*头结点*/
            Node head = new Node(Integer.parseInt(str[1]));
            /*构建一个完整链表*/
            for (int i = 1; i < n; i++) {
                /*以2个节点为一组，获取前节点和后节点，注意顺序*/
                /*前一个节点*/
                int pre = Integer.parseInt(str[2*i+1]);
                /*后一个节点*/
                int next = Integer.parseInt(str[2*i]);
                /*节点指针*/
                Node cur = head;
                /*从头结点遍历链表，找到pre这个节点*/
                /*注意：因为输入的关系，第一次cur.val == pre必定成立*/
                /*这里循环是为了找到pre，然后形成pre->next的局部链表*/
                while (cur.val != pre) {
                    cur = cur.next;
                }
                /*创建一个next节点，插入到pre后面*/
                Node node = new Node(next);
                node.next = cur.next;
                cur.next = node;
            }
            /*输入的最后一个值是要删除的*/
            int t = Integer.parseInt(str[2*n]);
            StringBuilder sb = new StringBuilder();
            Node cur = head;
            /*遍历链表，删除该值*/
            while (cur != null) {
                if (cur.val != t) {
                    sb.append(cur.val).append(" ");
                }
                cur = cur.next;
            }
            System.out.println(sb.toString());
        }
    }
}
