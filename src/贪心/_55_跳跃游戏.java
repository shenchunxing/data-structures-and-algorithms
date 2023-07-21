package 贪心;

/**
 * https://leetcode.cn/problems/jump-game/
 * 难度：中等
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 */
/*2023-7-5*/
public class _55_跳跃游戏 {
    /**
     * 贪心：每遍历到一个位置i，如果位置可达，记录最大的可达位置i + nums[i]
     * O(n) O(1)
     * [2, 3, 1, 1, 4]
     * 一开始更新位置在0，跳跃长度2，更新rightmost = 2
     *
     */

    public static void main(String[] args) {
        System.out.println(canJump(new int[] {2,3,1,1,4}));
        System.out.println(canJump(new int[] {3,2,1,0,4}));
    }

    /*贪心：每次尽量选择能够跳跃到更远位置的步数，从而在一次遍历中找到能够到达最后一个位置的方案*/
   static public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;//最远可达位置，默认0
        for (int i = 0; i < n; i++) {
            //首先判断当前位置 i 是否小于等于 rightmost，这是为了确保当前位置是可达的。如果不可达，即无法继续往后跳跃，直接跳过
            if (i <= rightmost) {
                //如果当前位置 i 是可达的，更新 rightmost 的值
                rightmost = Math.max(rightmost , i + nums[i]);
                //接着判断更新后的 rightmost 是否已经大于等于数组的最后一个位置 n - 1，如果是，则说明可以到达最后一个位置，返回 true。
                if (rightmost >= n - 1) return true;
            }
        }
        //遍历结束了，无法可达
        return false;
    }
}
