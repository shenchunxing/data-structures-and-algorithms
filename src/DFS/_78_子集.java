package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集
 */
/*2023-7-6*/
public class _78_子集 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[] {1,2,3}));
    }
    static public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        List<Integer> path = new ArrayList<>();//保存经过的路径
        dfs(nums,0,ans,path);
        return ans;
    }

    static private void dfs(int[] nums, int index , List<List<Integer>> ans, List<Integer> path) {
        /*已经遍历完数组，返回一个答案*/
        if (index == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        /*选一个值*/
        path.add(nums[index]);
        /*进入下一层，index++*/
        dfs(nums,index + 1,ans,path);
        /*回溯到此处，删掉最后的值*/
        path.remove(path.size() - 1);
        /*进入下一层，index++*/
        dfs(nums,index + 1,ans,path);
    }
}
