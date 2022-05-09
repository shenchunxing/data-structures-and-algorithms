import java.util.*;

public class LRUCache {
    //哈希表
    private Map<Integer, Node> map;
    //容量
    private int capacity;
    // 虚拟头结点
    private Node first;
    // 虚拟尾结点
    private Node last;

    public LRUCache(int capacity) {
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

        removeNode(node);//移除node节点，重新添加node节点到first后面
        addAfterFirst(node);

        return node.value;
    }

    /**
     * @param node 将node节点插入到first节点的后面
     */
    private void addAfterFirst(Node node) {
        // node与first.next
        node.next = first.next;
        first.next.prev = node;

        // node与first
        first.next = node;
        node.prev = first;
    }

    /**
     * @param node 从双向链表中删除node节点
     */
    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) { //如果已经存在链表中，则替换value，并从链表中删除掉。再加回到first后面
            node.value = value;
            removeNode(node);
        } else { // 添加一对新的key-value，如果已经达到了最大容量 ，则删除链表的最后节点，同时保存到哈希表，并插入该新节点到first后面
            if (map.size() == capacity) {
                // 淘汰最近最少使用的node\
                removeNode(map.remove(last.prev.key));
//                map.remove(last.prev.key);
//                removeNode(last.prev);
            }
            map.put(key, node = new Node(key, value));
        }
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
}
