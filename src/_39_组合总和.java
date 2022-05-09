import java.util.*;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */

public class _39_组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new LinkedList<>();

        if (candidates == null || candidates.length == 0) return lists;

        //排序
        Arrays.sort(candidates);
        Deque<Integer> deque = new LinkedList<>();

        dfs(candidates , candidates.length , target , 0 , deque , lists);

        return lists;
    }

    private void dfs(int[] candidates ,
                     int len ,
                     int residue ,
                     int begin ,
                     Deque<Integer> path ,
                     List<List<Integer>> lists) {

        if (residue == 0) {
            lists.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin  ; i < len ; i++) {
            //在数组有序的前提下剪支
            if (residue - candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);
            dfs(candidates , len , residue - candidates[i] , i ,path , lists );
            path.removeLast(); //回溯
        }

    }
}
