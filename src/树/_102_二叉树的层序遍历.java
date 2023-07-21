package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */
/*2023-7-5*/
public class _102_二叉树的层序遍历 {

    public static void main(String[] args) {
        // 构建一棵二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 测试 levelOrder 函数
        List<List<Integer>> result = levelOrder(root);
        System.out.println(result);  // 输出: [1，2，3，4，5]
    }

    /*层序遍历：队列*/
    static public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) return ret;

        /*queue用于保存每层的节点*/
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root); //根节点入队
        while (!queue.isEmpty()) { //队列不为空
            List<Integer> level = new ArrayList<Integer>();
            /*当前层的所有节点，需要记录，因为后续会逐个删除*/
            int currentLevelSize = queue.size(); //当前队列的数量，第一轮只有根结点，最多2个（左右节点）
            for (int i  = 0 ; i < currentLevelSize; i++) {
                TreeNode node = queue.poll(); //削掉第一个，第一轮削去根节点
                level.add(node.val);//将削掉的值加入到数组
                if (node.left != null) {
                    queue.offer(node.left); //左子树不为空，加入左子树到队列
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }
}


