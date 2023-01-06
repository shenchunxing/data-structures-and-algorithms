package DFS;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/permutation-sequence/
 * 给出集合[1,2,3,...,n]，其所有元素共有n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定n 和k，返回第k个排列。
 */
public class _60_排列序列 {
    /**
     * 记录数字是否使用过
     */
    private  boolean[] used;
    /**
     * 阶乘数组
     */
    private int[] factorial;
    private int k , n;
    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        calculateFactorial(n);
        used = new boolean[n + 1];
        Arrays.fill(used,false);
        StringBuilder builder = new StringBuilder();
        dfs(0,builder);
        return builder.toString();
    }

    /**
     * 在这一步之前已经选择了几个数字，其值恰好等于这一步需要确定的下标位置
     * @param index
     * @param builder
     */
    private void dfs(int index, StringBuilder builder) {
        if (index == n) return;

        // 计算还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n ; i++) {
            if (used[i]) continue; //已经使用过，剪枝
            //k不在当前i全排列之内
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            builder.append(i);
            used[i] = true;
            //去下一个全排列搜索
            dfs(index + 1,builder);
            // 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
            return;
        }
    }

    /**
     * 计算n的阶乘
     */
    private void calculateFactorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i < n;i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }
}
