package 队列;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
/*2023-7-11*/
public class 剑指Offer32_III_从上到下打印二叉树 {
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
       List<List<Integer>> ans = new LinkedList<List<Integer>>();
       if (root == null) {
           return ans;
       }

       Queue<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
       nodeQueue.offer(root);
       /*方向：默认从左到右*/
       boolean isOrderLeft = true;

       while (!nodeQueue.isEmpty()) {
           Deque<Integer> levelList = new LinkedList<Integer>();
           int size = nodeQueue.size();
           for (int i = 0; i < size; ++i) {
               TreeNode curNode = nodeQueue.poll();
               /*双端队列*/
               if (isOrderLeft) {
                   levelList.offerLast(curNode.val);
               } else {
                   levelList.offerFirst(curNode.val);
               }
               if (curNode.left != null) {
                   nodeQueue.offer(curNode.left);
               }
               if (curNode.right != null) {
                   nodeQueue.offer(curNode.right);
               }
           }
           ans.add(new LinkedList<Integer>(levelList));
           /*变换方向*/
           isOrderLeft = !isOrderLeft;
       }

       return ans;
   }
}
