package 贪心;

/**
 * https://leetcode.cn/problems/jump-game-ii/
 * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 */
public class _45_跳跃游戏II {
    public static void main(String[] args) {
        System.out.println(jump(new  int[] {2,3,1,2,4,2,3}));
    }
    /**
     * 正向查找,每一步都选择最远的
     */
   static public int jump(int[] nums) {
        int length = nums.length;
        int end = 0; // 上次跳跃可达范围右边界（下次的最右起跳点）
        int maxPostion = 0;//目前能跳的最远位置
        int steps = 0;//跳跃次数
        for (int i = 0; i < length - 1; i++) {
            maxPostion = Math.max(maxPostion,i + nums[i]);
            //到达上次跳跃能到达的右边界了
            if (i == end) {
                end = maxPostion;// 目前能跳到的最远位置变成了下次起跳位置的右边界
                steps++;// 进入下一次跳跃
            }
        }
        return steps;
    }
    /**
     * 贪心；反向查找，最后一步可达，则改变终点位置
     * O(n^2) O(1)
     */
    public int jump2(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position ; i++) {
                if (i + nums[i] >= position) { //可以到达终点
                    position = i; //改变终点位置
                    steps ++;
                    break;
                }
            }
        }
        return steps;
    }
}
