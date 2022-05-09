import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.sun.source.tree.Tree;
import common.TreeNode;

public class _102_二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) return ret;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root); //根节点入队
        while (!queue.isEmpty()) { //队列不为空
            List<Integer> level = new ArrayList<Integer>();
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


