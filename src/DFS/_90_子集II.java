package DFS;

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
        //不选择当前值
        dfs(nums,start + 1,false,ans,t);

        //上一个相同的数没有被选择，为了让子集不重复，这次也跳过。
        if (!choosed && start > 0 && nums[start] == nums[start - 1]) {
            return;
        }

       //选择了当前值
        t.add(nums[start]);
        dfs(nums,start + 1,true,ans,t);//选择后，进入下一层
        t.remove(t.size() - 1); //回溯，删除当前值
    }
}
