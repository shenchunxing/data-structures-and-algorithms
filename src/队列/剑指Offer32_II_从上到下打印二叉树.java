package 队列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

/**
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * 难度：中等
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
/*2023-7-11*/
public class 剑指Offer32_II_从上到下打印二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }

    /*层序遍历*/
   static public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> ret = new ArrayList<List<Integer>>();
       if (root == null) {
           return ret;
       }

       Queue<TreeNode> queue = new LinkedList<TreeNode>();
       queue.offer(root);
       while (!queue.isEmpty()) {
           /*每一层新建一个List*/
           List<Integer> level = new ArrayList<Integer>();
           int currentLevelSize = queue.size();
           for (int i = 1; i <= currentLevelSize; ++i) {
               TreeNode node = queue.poll();
               level.add(node.val);
               if (node.left != null) {
                   queue.offer(node.left);
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
