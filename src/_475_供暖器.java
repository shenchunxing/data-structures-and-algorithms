import java.util.Arrays;

/**
 * https://leetcode.cn/problems/heaters/
 */
public class _475_供暖器 {
    public static void main(String[] args) {
        _475_供暖器 o = new  _475_供暖器();
        System.out.println(o.findRadius(new int[] {1,5},new int[] {2}));
    }
    // 对于每个房屋，应该选择离该房屋最近的供暖器覆盖该房屋，最近的供暖器和房屋的距离即为该房屋需要的供暖器的最小加热半径。
    // 所有房屋需要的供暖器的最小加热半径中的最大值即为可以覆盖所有房屋的最小加热半径。
    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            //通过二分查找得到距离最近的供暖器
            int i= binarySearch(heaters,house);
            int j = i + 1;
            //距离house的左侧供暖器的距离
            int leftDistance = i < 0 ? Integer.MAX_VALUE : house - heaters[i];
            //距离house的右侧供暖器的距离
            int rightDistance = j >= heaters.length ? Integer.MAX_VALUE :  heaters[j] - house;
            //可以覆盖的距离较近的供暖器
            int curDistance = Math.min(leftDistance,rightDistance);
            ans = Math.max(ans,curDistance);
        }
        return ans;
    }

    /**
     * 找到距离房子最近的供暖器
     */
    private int binarySearch(int[] nums , int target) {
        int left = 0 ,right = nums.length - 1;
        if (nums[left] > target) return -1;
        while (left < right) {
            int mid = (right - left + 1) /2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else  {
                left = mid;
            }
        }
        return left;
    }
}
