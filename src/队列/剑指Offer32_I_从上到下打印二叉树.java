package 队列;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * 难度：中等
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
/*2023-7-11*/
public class 剑指Offer32_I_从上到下打印二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(Arrays.toString(levelOrder(root)));
    }

    /*层序遍历*/
   static public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            arrayList.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        /*List转int[]*/
        int[] res = new int[arrayList.size()];
        for (int i = 0 ; i < arrayList.size();i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }
}
