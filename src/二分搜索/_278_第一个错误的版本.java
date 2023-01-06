package 二分搜索;

/**
 * https://leetcode.cn/problems/first-bad-version/
 */
public class _278_第一个错误的版本 {
    public int firstBadVersion(int n) {
        int left = 1,right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else  {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int version) {
        return true;
    }
}
