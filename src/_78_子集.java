import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集
 */
public class _78_子集 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[] {1,2,3}));
    }

   static public List<List<Integer>> subsets(int[] nums) {
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return ans;
        dfs(nums,0, ans ,t);
        return ans;
    }

    static private void dfs(int[] nums , int start ,List<List<Integer>> ans, List<Integer> t) {
        if (start == nums.length) { //遍历结束，获得一个解
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[start]);//选择当前数
        dfs(nums,start + 1,ans,t); //进入下一层
        t.remove(t.size() - 1); //删除当前选择的数
        dfs(nums,start + 1,ans,t); //不选择当前数字
    }
}
