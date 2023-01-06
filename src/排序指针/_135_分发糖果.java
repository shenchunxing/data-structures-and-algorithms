package 排序指针;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/candy/
 */
public class _135_分发糖果 {
    public static void main(String[] args) {
        _135_分发糖果 o = new _135_分发糖果();
        System.out.println(o.candy(new int[] {1,0,2}));
    }
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])  left[i] = left[i - 1] + 1; //满足左规则
        }
        int count = left[ratings.length - 1]; //统计左规则需要分发的糖果数量
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;//满足右规则
            count += Math.max(left[i], right[i]); //同时满足左右规则
        }
        return count;
    }
}
