package common;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {

    }
    public TreeNode(int x) {
        val = x;
    }

    public static void preorderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    @Override
    public String toString() {
        List<String> nodes = new ArrayList<>();
        buildString(this, nodes);
        return "[" + String.join(",", nodes) + "]";
    }

    private void buildString(TreeNode node, List<String> nodes) {
        if (node == null) {
            nodes.add("null");
        } else {
            nodes.add(String.valueOf(node.val));
            buildString(node.left, nodes);
            buildString(node.right, nodes);
        }
    }
}
