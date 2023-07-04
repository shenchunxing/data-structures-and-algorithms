package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
/*2023-7-4*/
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
        /*排序就是为了去重*/
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
            /**
            used[i] 表示第 i 个元素是否已经被使用过，如果已经被使用过，则跳过该元素
            (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) 的判断条件用于检查当前元素 nums[i] 是否与前一个元素相同，并且前一个元素在当前层级中没有被使用过。如果满足这两个条件，说明当前元素与前一个元素重复，并且前一个元素的排列已经在之前的递归中生成过了，因此可以跳过当前元素，避免生成重复的排列。
            */
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums,idx + 1,ans,path,used);//下一层
            /*回溯需要移除value的同时，状态也要置为false*/
            used[i] = false;
            path.remove(idx);
        }
    }


}
