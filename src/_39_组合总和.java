import java.util.*;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的数字可以无限制重复被选取。
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
