import java.util.*;

/**
 * https://leetcode.cn/problems/combination-sum-ii/
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。
 */
public class _40_组合总和II {
    public static void main(String[] args) {
        _40_组合总和II ob = new _40_组合总和II();
        System.out.println(ob.combinationSum2(new int[] {10,1,2,7,6,1,5} , 8));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;
        Arrays.sort(candidates);
        Deque<Integer> path = new LinkedList<>();
        dfs(candidates,len,0,target,path,res);
        return res;
    }

    /**
     * 从第level层开始搜索，每一层target = target - candidates[i]，剩余的值进入下一层，直到找到target = 0的，返回一个答案。
     */
    private void dfs(int[] candidates, int len , int level , int target, Deque<Integer> path , List<List<Integer>> res) {
        if (target == 0) { //剩余值为0，返回一个答案
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = level; i < len; i++) { //当前可选的范围
            //大剪枝：减去 candidates[i] 小于 0，
            //减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
            if (target - candidates[i] < 0) {
                break;
            }
            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            //i > level为了防止数组越界
            if (i > level && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]); //添加到路径下
            //进入下一层
            dfs(candidates,len, i + 1, target - candidates[i],path,res);
            //回溯
            path.removeLast();
        }
    }
}
