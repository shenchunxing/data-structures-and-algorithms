import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/find-duplicate-subtrees/
 */
public class _652_寻找重复的子树 {
    //序列化
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String,Integer> map = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        collect(root,ans,map);
        return ans;
    }

    /**
     * 序列化:统计node节点为根节点的情况下，形成的子树是否重复，如果重复，加入答案数组
     */
    private String collect(TreeNode node , List<TreeNode> ans, Map<String,Integer> map) {
        if (node == null) return "#";
        String serial = node.val + "," + collect(node.left,ans,map) + "," + collect(node.right,ans,map);
        //统计node节点下，重复子树的个数，如果大于2，说明该节点是重复子树的根节点
        map.put(serial,map.getOrDefault(serial,0) + 1);
        if (map.get(serial) == 2) { //重复了
            ans.add(node);
        }
        return serial;
    }
}
