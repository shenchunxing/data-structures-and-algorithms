public class _287_寻找重复数 {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1,r = n - 1,ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1; //获取数组中间位置的下标n/2
            int cnt = 0;
            //假设n=10
            //假设重复数是k = 6，则<=k的值有k+1个，>k的值有n-k个
            //mid = 5
            for (int i = 0; i < n ;i ++) {
                if (nums[i] <= mid) { //数组中间下标 >= i对应的值
                    cnt ++;
                }
            }
            //正常情况下，没有那个重复数字，会是cnt <= mid，有了重复数字，若在mid左侧，则cnt>mid。
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
