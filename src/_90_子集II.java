import java.util.*;

/**
 * https://leetcode.cn/problems/subsets-ii/
 */
public class _90_子集II {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[] {1,2,2}));
    }

    static public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> t = new LinkedList<>();
        if (nums == null || nums.length == 0) return ans;
        Arrays.sort(nums); //排序
        dfs(nums,0,false,ans,t);
        return ans;
    }

    /**
     * 1 2 2
     * 打印顺序：[[], [2], [2, 2], [1], [1, 2], [1, 2, 2]]
     * 一路不选[],结束之后回溯到最后一个2，选了2，进入下一层，到达终点，返回[2]
     */
   static private void dfs(int[] nums , int start, boolean choosed,
                           List<List<Integer>> ans, List<Integer> t) {
        if (start == nums.length) { //到达终点，返回一个解
            ans.add(new LinkedList<>(t));
            return;
        }
        dfs(nums,start + 1,false,ans,t);
        //对于当前选择的数nums[start]，若前面有与其相同的数nums[start - 1]，且没有选择nums[start - 1]，此时包含nums[start]的子集，
        // 必然会出现在包含nums[start]的所有子集中
        if (!choosed && start > 0 && nums[start] == nums[start - 1]) {
            return;
        }
        t.add(nums[start]);//选择了当前值
        dfs(nums,start + 1,true,ans,t);//选择后，进入下一层
        t.remove(t.size() - 1); //回溯，删除当前值
    }
}
