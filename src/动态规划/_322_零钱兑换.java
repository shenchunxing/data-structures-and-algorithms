package 动态规划;

/**
 * https://leetcode.cn/problems/coin-change/
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * 你可以认为每种硬币的数量是无限的。
 */
/*2023-7-6，还需要理解下*/
public class _322_零钱兑换 {

    public static void main(String[] args) {
        System.out.println(coins5(41, new int[] {1, 5, 25, 20}));
    }

    static int coins5(int n, int[] faces) {
        if (n < 1 || faces == null || faces.length == 0) return 0;
        int[] dp = new int[n + 1];
        //每一轮可以得到满足最大值是i的情况下，最小的硬币个数。
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int face : faces) { //选择硬币
                if (i < face) continue; //当前数小于硬币，无法选择硬币
                int v = dp[i - face];//选了face面值的硬币，同时计算凑够i - face，需要的最少硬币个数
                if (v < 0 || v >= min) continue; //不合法，跳过就行
                min = v;//记录凑够i，需要的最少硬币个数，这个值没加上选择的face面值的硬币，最后计算的时候需要加上
            }
            if (min == Integer.MAX_VALUE) { //没有选择过硬币
                dp[i] = -1;
            } else { //选择了硬币
                dp[i] = min + 1;
            }
        }
        return dp[n];
    }

    static int coins4(int n) {
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        // faces[i]是凑够i分时最后那枚硬币的面值
        int[] faces = new int[dp.length];
        for (int i = 1; i <= n; i++) {
            int min = dp[i - 1];
            faces[i] = 1;

            if (i >= 5 && dp[i - 5] < min) {
                min = dp[i - 5];
                faces[i] = 5;
            }
            if (i >= 20 && dp[i - 20] < min) {
                min = dp[i - 20];
                faces[i] = 20;
            }
            if (i >= 25 && dp[i - 25] < min) {
                min = dp[i - 25];
                faces[i] = 25;
            }
            dp[i] = min + 1;
            print(faces, i);
        }
//		print(faces, n);
        return dp[n];
    }

    static void print(int[] faces, int n) {
        System.out.print("[" + n + "] = ");
        while (n > 0) {
            System.out.print(faces[n] + " ");
            n -= faces[n];
        }
        System.out.println();
    }

    /**
     * 递推（自底向上），也就是迭代
     */
    static int coins3(int n) {
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            //  if (i >= 1) ,确保dp不越界
            if (i >= 1) min = Math.min(dp[i - 1], min);
            if (i >= 5) min = Math.min(dp[i - 5], min);
            if (i >= 20) min = Math.min(dp[i - 20], min);
            if (i >= 25) min = Math.min(dp[i - 25], min);
            dp[i] = min + 1;
        }
        return dp[n];
    }

    /**
     * 记忆化搜索（自顶向下的调用），减少了重复递归。把以前计算过的值存起来
     */
    static int coins2(int n) {
        if (n < 1) return -1;
        int[] dp = new int[n + 1]; //dp表示的是凑够n分，需要的硬币个数
        int[] faces = {1, 5, 20, 25};
        for (int face : faces) {
            if (n < face) break; //如果n都小于当前硬币面值，说明选不了了。直接break
            dp[face] = 1;//凑够1/5/20/25的最少硬币个数都是1。dp[1] = 1,dp[5] = 1,dp[20] = 1,dp[25] = 1
        }
        return coins2(n, dp);
    }

    static int coins2(int n, int[] dp) {
        if (n < 1) return Integer.MAX_VALUE;
        if (dp[n] == 0) { //说明没有计算过，需要计算。否则就是重复计算，每个n只会进入一次。
            int min1 = Math.min(coins2(n - 25, dp), coins2(n - 20, dp));
            int min2 = Math.min(coins2(n - 5, dp), coins2(n - 1, dp));
            dp[n] = Math.min(min1, min2) + 1;
        }
        return dp[n];
    }
}
