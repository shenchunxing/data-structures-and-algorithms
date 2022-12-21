import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 */
public class _46_全排列_中等_dfs {
    public static void main(String[] args) {
        System.out.println(permute(new int[] {0,1}));
        System.out.println(permute(new int[] {1,2,3}));
    }

   static public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) return list;
        int[] result = new int[nums.length];/** 用来保存每一层选择的数字 */
        boolean[] used = new boolean[nums.length];/** 用来标记nums中的数字是否被使用过了 */
        dfs(0,list,nums,result,used);
        return list;
    }

    static private void dfs(int idx,List<List<Integer>> list,int[] nums,int[] result,boolean[] used) {
        // 不能再往下搜索,得到一个解
        if (idx == nums.length) {
            List<Integer> resultList = new ArrayList<>();
            for (int value : result) {
                resultList.add(value);
            }
            list.add(resultList);
            return;
        }

        // 枚举这一层所有可以做出的选择
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; //去重
            result[idx] = nums[i];//选择一个数字
            used[i] = true;//使用了

            dfs(idx + 1,list,nums,result,used);//进入下一层

            // 出了一个结果，则还原现场（一层层递归出来，最后每个值都是false了）。进入下一个循环。
            used[i] = false;
        }
    }
}
