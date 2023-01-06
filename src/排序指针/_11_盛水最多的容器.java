package 排序指针;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class _11_盛水最多的容器 {

    //双指针：相同情况下两边距离越远越好，区域面积受限于较短边
    //每次固定较长边，短边向内移动，计算面积。
    public int maxArea0(int[] height) {
        if (height == null || height.length == 0) return 0;

        int l = 0, r = height.length - 1, water = 0;//初始位置为左右两边
        while (l < r) {
            if (height[l] <= height[r]) {
                water = Math.max(water, (r - l) * height[l]);//计算面积
                l++; //向内移动较短边的指针
            } else {
                water = Math.max(water, (r - l) * height[r]);//计算面积
                r--; //向内移动较短边的指针
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
