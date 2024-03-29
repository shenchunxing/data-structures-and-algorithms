package DFS;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的数字可以无限制重复被选取。
 */

/*2023-7-4*/
public class _39_组合总和 {
    public static void main(String[] args) {
        List<List<Integer>> result1 = combinationSum(new int[] {1,2,3},6);
        System.out.println(result1);
    }

   static public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        Arrays.sort(candidates); //排序
        List<List<Integer>> lists = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        dfs(candidates,candidates.length,target,0,lists,deque);
        return lists;
    }

    /**
     * 递归查找
     * @param remain 剩余数大小
     * @param begin 开始位置
     */
    static private void dfs(int[] candidates, int len, int remain, int begin , List<List<Integer>> lists,
                     Deque<Integer> deque) {
        if (remain == 0) { //剩余为0，返回一个解
            lists.add(new ArrayList<>(deque));
            return;
        }
        //遍历每一个元素，选中后进入下一层，发现不对，则回溯重新选择
        for (int i = begin; i < len; i++) {
            //当前值比剩余的总值都要大了，直接剪枝
            if (candidates[i] > remain) break;
            //添加进结果队列，作为结果的一部分
            deque.add(candidates[i]);
            //进入下一层：剩余距离target的值是remain - candidates[i]，当前的起始位置是i
            dfs(candidates,len,remain - candidates[i],i,lists,deque);
            deque.removeLast(); //回溯需要删除最后的那个值
        }
    }
}
