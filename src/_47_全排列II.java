import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class _47_全排列II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,0,ans,path,used);
        return ans;
    }

    private void dfs(int[] nums, int idx, List<List<Integer>> ans, List<Integer> path, boolean[] used) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //已经被使用过，直接跳过
            //和上一个重复了，我们规定相同的数以第一次出现的为结果，其他情况都过滤掉，上一次没选，这次直接过滤掉
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

    public static void main(String[] args) {
        _47_全排列II o = new _47_全排列II();
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = o.permuteUnique(nums);
        System.out.println(list);

        nums = new int[]{1, 1, 3};
        list = o.permuteUnique(nums);
        System.out.println(list);
    }
}
