package 树;

/**
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * 本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 * 难度：中等
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class 剑指Offer36_二叉搜索树与双向链表_不懂 {
    /**
     *  要排序，则应该使用中序遍历，
     *  双向链表：pre.right = cur,cur.left = pre
     *  循环链表：head.left = tail,tail.right = head
     */
    Node pre, head; //head是头节点，pre是当前节点的上一个节点
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        //遍历结束，pre指向最后一个节点，需要满足循环链表的特性
        //头节点的左节点是尾节点，尾节点的右节点是头节点
        head.left = pre;
        pre.right = head;
        return head;
    }

    /**
     *  中序遍历
     * @param node
     */
    private void dfs(Node node) {
        if (node == null) return;
        dfs(node.left); //左
        //需要判断pre是否存在，默认pre是null，则head指向node，此时node就是root
        //pre存在，则pre的右节点就是node节点
        //满足双向链表的指向逻辑
        if (pre != null) pre.right = node;
        else head = node;
        node.left = pre;
        pre = node;
        dfs(node.right);//右
    }

    public class Node {
        int val;
        Node left;
        Node right;
    }
}
