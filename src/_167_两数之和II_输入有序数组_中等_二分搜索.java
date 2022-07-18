/**
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 */
public class _167_两数之和II_输入有序数组_中等_二分搜索 {

    //双指针：逐渐逼近
    public int[] twoSum(int[] numbers, int target) {
        int low = 0,high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[] {low + 1,high + 1}; // 题意要求下标从1开始，所以强制+1
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[] {-1,-1};
    }

    //二分搜索
    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) { //寻找第一个数O(n)
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {  //寻找第二个数O(logN)
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
}
