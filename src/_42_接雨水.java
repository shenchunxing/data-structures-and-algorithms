/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * @author MJ
 */
public class _42_接雨水 {

    /**
     * 空间复杂度O(1)，时间复杂度O(n)
     */
    //最精简版：双指针
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        //lowerMax是lower里面最大的那个
        int lowerMax = 0 , l = 0,r = height.length - 1,water = 0;
        while (l < r) {
            //取出左右较小的柱子，该柱子决定放水
            int lower = height[height[l] < height[r] ? l++ : r--];
            //更新lowerMax，该值作为标杆的，决定放水的多少。
            lowerMax = Math.max(lowerMax,lower);
            //差值即使放水的数量
            water += lowerMax - lower;
        }
        return  water;
    }

    /**
     * 继续优化，去掉了rightmaxes
     * @param height
     * @return
     */
    public int trap0(int[] height) {
        if (height == null || height.length == 0) return 0;

        int lastIdx = height.length - 2;//height.length - 1是最后一个柱子，肯定不能防水
        // 遍历每一根柱子，看看每一根柱子上能放多少水
        int water = 0, leftMax = 0;
        //第1根柱子肯定不能防水，因为左边没有比他更大的柱子
        for (int i = 1; i <= lastIdx; i++) {
            leftMax = Math.max(leftMax, height[i - 1]);
            // 求出左边最大、右边最大中的较小者
            int min = Math.min(leftMax, height[i - 1]);
            // 说明这根柱子不能放水
            if (min <= height[i]) continue;
            // 说明这根柱子能放水
            water += min - height[i];
        }

        return water;
    }

    /**
     * 在trap0基础上优化，去掉了leftmaxes数组
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        if (height == null || height.length == 0) return 0;

        int lastIdx = height.length - 2;

        int[] rightMaxes = new int[height.length];
        for (int i = lastIdx; i >= 1; i--) {
            rightMaxes[i] = Math.max(rightMaxes[i + 1], height[i + 1]);
        }

        // 遍历每一根柱子，看看每一根柱子上能放多少水
        int water = 0, leftMax = 0;
        for (int i = 1; i <= lastIdx; i++) {
            leftMax = Math.max(leftMax, height[i - 1]);
            // 求出左边最大、右边最大中的较小者
            int min = Math.min(leftMax, rightMaxes[i]);
            // 说明这根柱子不能放水
            if (min <= height[i]) continue;
            // 说明这根柱子能放水
            water += min - height[i];
        }

        return water;
    }

    //柱子能放水的前提：左右各有比它大的柱子
    //放水的多少看左边最大的柱子和右边最大的柱子两者较小的那个
    public int trap2(int[] height) {
        if (height == null || height.length == 0) return 0;

        int lastIdx = height.length - 2;
        int[] leftMaxes = new int[height.length];
        //动态规划思想：i - 1位置的最大值和i- 1位置的值进行比较，较大值存入数组。得到了左右最大值的数组
        for (int i = 1; i <= lastIdx; i++) {
            leftMaxes[i] = Math.max(leftMaxes[i - 1], height[i - 1]);
        }

        int[] rightMaxes = new int[height.length];
        for (int i = lastIdx; i >= 1; i--) {
            rightMaxes[i] = Math.max(rightMaxes[i + 1], height[i + 1]);
        }

        // 遍历每一根柱子，看看每一根柱子上能放多少水
        int water = 0;
        //第1根柱子肯定不能防水，因为左边没有比他更大的柱子。最后一根柱子不能防水，因为右边没有更大的柱子
        for (int i = 1; i <= lastIdx; i++) {
            // 求出左边最大、右边最大中的较小者
            int min = Math.min(leftMaxes[i], rightMaxes[i]);
            // 当前柱子更高，不能放水
            if (min <= height[i]) continue;

            water += min - height[i];
        }

        return water;
    }

}
