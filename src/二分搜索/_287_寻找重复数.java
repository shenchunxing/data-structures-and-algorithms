package 二分搜索;

public class _287_寻找重复数 {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
    }
    //O(logn)
   static public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1,r = n - 1,ans = -1;
        //o(logn)
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            //为了确认重复数字在左边区还是右边区
            for (int i = 0; i < n ;i ++) {
                if (nums[i] <= mid) { //数组中间下标 >= i对应的值
                    cnt ++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            }else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
