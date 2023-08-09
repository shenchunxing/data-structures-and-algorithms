package 牛客网;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 商店里有N件唯一性商品，每件商品有一个价格，第 i 件商品的价格是 ai。
 * 一个购买方案可以是从N件商品种选择任意件进行购买（至少一件），花费即价格之和。
 * 现在你需要求出所有购买方案中花费前K小的方案，输出这些方案的花费。
 * 当两个方案选择的商品集合至少有一件不同，视为不同方案，因此可能存在两个方案花费相同
 *
 * 输入描述
 *
 * 输入数据含两行：
 * 第一行包含两个整数N，K，整数之间通过空格隔开。分别表示商品的个数，以及需要求得的花费个数。1 ≤ N ≤ 10000，1 ≤ K ≤ min(2^N – 1，100000)
 * 第二行包含N个整数a1，a2，…，an，整数之间通过空格隔开。表示N件商品的价格。1≤ a1≤ a2≤ …≤ an≤ 10000
 *
 * 输出描述
 *
 * 按花费从小到大的顺序依次输出K行，一行一个整数。表示花费前K小的购买方案的花费。
 */
public class 购物 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int j = 0; j < n; j++) {
            nums[j] = sc.nextInt();
        }
        getResult(n, k, nums);
    }
    public static void getResult(int n, int m, int[] nums) {
        Arrays.sort(nums);
        // 对于一个组合模型，其”将要产生的新组合“之和越小，则优先级越高
        // curSum + nums[nextIdx] 为 ”将要产生的新组合“之和
        PriorityQueue<CombineModel> pq =
                new PriorityQueue<>((a, b) -> a.curSum + nums[a.nextIdx] - (b.curSum + nums[b.nextIdx]));
        // 空组合的和为0, 将要加入的新元素是nums[0], 即索引0的元素，其将要产生的新组合之和为 0 + nums[0]
        CombineModel c = new CombineModel(0, 0);
        for (int i = 1; i <= m; i++) {
            // 打印第 i 小组合
            System.out.println(c.curSum + nums[c.nextIdx]);
            // c是当前最小组合模型，最小的组合模型指的是将要产生的新组合之和在对应轮次中最小
            // 如果当前组合模型c还有可合入的下一个元素，即c.nextIdx + 1 < n, 则说明可以基于当前组合模型产生一个新组合
            if (c.nextIdx + 1 < n) {
                // 基于当前组合模型产生的新组合，也是本轮最小的组合，即第 i 小组合
                pq.offer(new CombineModel(c.curSum + nums[c.nextIdx], c.nextIdx + 1));
                // 当前组合需要更新nextIdx后，重新加入优先队列
                c.nextIdx += 1;
                pq.offer(c);
            }
            // 取出优先队列中最小组合（注意这里的最小，指的是基于当前组合，将要产生的新组合之和最小）
            c = pq.poll();
        }
    }
    static class CombineModel {
        int curSum; // 当前组合之和
        int nextIdx; // 将要被加入当前组合的新元素索引位置
        public CombineModel(int curSum, int nextIdx) {
            this.curSum = curSum;
            this.nextIdx = nextIdx;
        }
    }
}
