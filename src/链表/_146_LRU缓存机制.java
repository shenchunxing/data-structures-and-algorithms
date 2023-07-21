package 链表;

import com.mj.Asserts;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 */
public class _146_LRU缓存机制 {
    //哈希表
    private Map<Integer, Node> map;
    //容量
    private int capacity;
    // 虚拟头结点
    private Node first;
    // 虚拟尾结点
    private Node last;

    public _146_LRU缓存机制(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        first = new Node();
        last = new Node();
        first.next = last; //双向链表
        last.prev = first;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        /*因为查询了该节点，需移除node节点，重新添加node节点到first后面*/
        removeNode(node);
        addAfterFirst(node);
        return node.value;
    }

    /*将node节点插入到first节点的后面*/
    private void addAfterFirst(Node node) {
        // node与first.next
        node.next = first.next;
        first.next.prev = node;

        // node与first
        first.next = node;
        node.prev = first;
    }

    /*从双向链表中删除node节点*/
    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        /*如果已经存在链表中，则替换value，并从链表中删除掉。再加回到first后面*/
        if (node != null) {
            node.value = value;
            removeNode(node);
            /*添加一对新的key-value*/
        } else {
            /*如果已经达到了最大容量 ，则删除链表的最后节点*/
            if (map.size() == capacity) {
                // 淘汰最近最少使用的node
                removeNode(map.remove(last.prev.key));
            }
            /*同时更新哈希表*/
            map.put(key, node = new Node(key, value));
        }
        /*添加到链表头部*/
        addAfterFirst(node);
    }

    private static class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public Node() {}
    }

    public static void main(String[] args) {
        _146_LRU缓存机制 cache = new _146_LRU缓存机制( 2 /* 缓存容量 */ );
        cache.put(1, 1);
        cache.put(2, 2);
        Asserts.test(cache.get(1) == 1); // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        Asserts.test(cache.get(2) == -1);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        Asserts.test(cache.get(1) == -1);       // 返回 -1 (未找到)
        Asserts.test(cache.get(3) == 3);       // 返回  3
        Asserts.test(cache.get(4) == 4);       // 返回  4
    }

}
