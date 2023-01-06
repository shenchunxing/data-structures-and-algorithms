package 树;

import common.TreeNode;

import java.util.*;

/**
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 */
public class _103_二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;//默认从右往左，控制入队方向

        while (!nodeQueue.isEmpty()) {
            //双端队列
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) { //从尾部入队
                    levelList.offerLast(curNode.val);
                } else {//从头部入队
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
            //每一层遍历结束，转换遍历方向
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }
}
