import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集
 */
public class _78_子集_中等_dfs {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        List<Integer> path = new ArrayList<>();
        dfs(nums,0,ans,path);
        return ans;
    }

    private void dfs(int[] nums, int begin , List<List<Integer>> ans, List<Integer> path) {
        if (begin == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[begin]);
        dfs(nums,begin + 1,ans,path); //进入下一个选择（得到长度和nums一样的解）
        path.remove(path.size() - 1); //移除
        dfs(nums,begin + 1,ans,path);//进入下一个选择（得到长度比nums少的解）
    }
}
