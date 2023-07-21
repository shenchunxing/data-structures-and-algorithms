package 排序指针;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 *
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 */
public class _11_盛水最多的容器 {
    public static void main(String[] args) {
        System.out.println(maxArea0(new int[] {1,8,6,2,5,4,8,3,7}));//49
    }
    //双指针：相同情况下两边距离越远越好，区域面积受限于较短边
    //每次固定较长边，短边向内移动，计算面积。
   static public int maxArea0(int[] height) {
        if (height == null || height.length == 0) return 0;
        /*l、r表示左右指针，water表示水*/
        int l = 0, r = height.length - 1, water = 0;
        while (l < r) {
            /*左边短，右边长，因为盛水是依赖短边的，让l++*/
            if (height[l] <= height[r]) {
                water = Math.max(water, (r - l) * height[l]);
                l++;
            } else {
                water = Math.max(water, (r - l) * height[r]);
                r--;
            }
        }
        return water;
    }

    public int maxArea1(int[] height) {
        if (height == null || height.length == 0) return 0;

        int l = 0, r = height.length - 1, water = 0;
        while (l < r) {
            int minH = Math.min(height[l], height[r]);
            water = Math.max(water, minH * (r - l));
            while (l < r && height[l] <= minH) l++;
            while (l < r && height[r] <= minH) r--;
        }
        return water;
    }

    public int maxArea2(int[] height) {
        if (height == null || height.length == 0) return 0;

        int l = 0, r = height.length - 1, water = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                int minH = height[l];
                water = Math.max(water, (r - l) * minH);
                while (l < r && height[l] <= minH) l++;
            } else {
                int minH = height[r];
                water = Math.max(water, (r - l) * minH);
                while (l < r && height[r] <= minH) r--;
            }
        }
        return water;
    }

    public int maxArea3(int[] height) {
        if (height == null || height.length == 0) return 0;

        int l = 0, r = height.length - 1, water = 0;
        while (l < r) {
            int minH = (height[l] <= height[r]) ? height[l++] : height[r--];
            water = Math.max(water, minH * (r - l + 1));
        }
        return water;
    }

}
