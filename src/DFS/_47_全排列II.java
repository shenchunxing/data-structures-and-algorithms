package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class _47_全排列II {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,2,3}));
        System.out.println(permuteUnique(new int[]{1,1,3}));
    }

   static public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,0,ans,path,used);
        return ans;
    }

   static private void dfs(int[] nums, int idx, List<List<Integer>> ans, List<Integer> path, boolean[] used) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //剪枝：已经使用过的
            //剪枝：相同的选项这次没选，那上一次也不能选
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums,idx + 1,ans,path,used);//下一层
            used[i] = false;
            path.remove(idx);//回溯
        }
    }


}
