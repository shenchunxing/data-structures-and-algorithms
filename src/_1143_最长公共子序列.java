import java.util.Enumeration;

/**
 * https://leetcode.cn/problems/longest-common-subsequence/
 */
public class _1143_最长公共子序列 {
    public static void main(String[] args) {
//        int len = longestCommonSubsequence("abcde" ,"ace");
//        System.out.println(len);

        int len = lcs(new int[] { 1,3,5,9,10} , new int[] {1,4,9,10});
        System.out.println(len);
    }

    //动态规划
    static public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        char[] chars1 = text1.toCharArray();
        if (chars1.length == 0) return 0;
        char[] chars2 = text2.toCharArray();
        if (chars2.length == 0) return 0;
        char[] rowsChars = chars1, colsChars = chars2;
        if (chars1.length < chars2.length) {
            colsChars = chars1;
            rowsChars = chars2;
        }
        int[] dp = new int[colsChars.length + 1];
        for (int i = 1; i <= rowsChars.length; i++) {
            int cur = 0;
            for (int j = 1; j <= colsChars.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (rowsChars[i - 1] == colsChars[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[colsChars.length];
    }

    //节约内存，可以使用数组较短的作为dp
    static public int lcs0(int[] nums1 , int[] nums2) {
        if (nums1 == null || nums1.length == 0) return 0;
        if (nums2 == null || nums2.length == 0) return 0;
        int[] dp = new int[nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            int cur = 0;//外层循环每次清空
            for (int j = 1; j <= nums2.length; j++) {
                int leftTop = cur; //获取上一行的dp[j]
                cur = dp[j]; //存起来当前的dp[j]
                if (nums1[i - 1] == nums2[j - 1]) { //最后一个元素是相等的，则是dp[i - 1][j - 1] + 1
                    dp[j] = leftTop + 1;
                } else { //最后一个元素不相等，但是可能和前面的元素相等，两种情况都要考虑
                    dp[j] = Math.max(dp[j] , dp[j - 1]);
                }
            }
        }
        return dp[nums2.length];
    }

    //因为dp只和lefttop，top ,left 有关，只涉及到当前行和上一行，可以继续优化，变成一维数组,数组长度较短的作为dp
    static public int lcs(int[] nums1 , int[] nums2) {
        if (nums1 == null || nums1.length == 0) return 0;
        if (nums2 == null || nums2.length == 0) return 0;
        int[] rows = nums1 ,  cols = nums2;
        if (nums1.length < nums2.length) {
            cols = nums1;
            rows = nums2;
        }
        int[] dp = new int[cols.length + 1];
        for (int i = 1; i <= rows.length; i++) {
            int cur = 0;
            for (int j = 1; j <= cols.length; j++) {
                int leftTop = cur; //获取上一行的dp[j]
                cur = dp[j]; //存起来当前的dp[j]
                if (nums1[i - 1] == nums2[j - 1]) { //最后一个元素是相等的，则是dp[i - 1][j - 1] + 1
                    dp[j] = leftTop + 1;
                } else { //最后一个元素不相等，但是可能和前面的元素相等，两种情况都要考虑
                    dp[j] = Math.max(dp[j] , dp[j - 1]);
                }
            }
        }
        return dp[cols.length];
    }

    //因为dp只和lefttop，top ,left 有关，只涉及到当前行和上一行，因此可以用滚动数组继续优化
    static public int lcs1(int[] nums1 , int[] nums2) {
        if (nums1 == null || nums1.length == 0) return 0;
        if (nums2 == null || nums2.length == 0) return 0;
        int[][] dp = new int[2][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            int row = i % 2;
            int prevRow = (i - 1) % 2;
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) { //最后一个元素是相等的，则是dp[i - 1][j - 1] + 1
                    dp[row][j] = dp[prevRow][j - 1] + 1;
                } else { //最后一个元素不相等，但是可能和前面的元素相等，两种情况都要考虑
                    dp[row][j] = Math.max(dp[prevRow][j] , dp[row][j - 1]);
                }
            }
        }
        //滚动数组的长度已经变成了2，所以应该写成nums1.length % 2
        return dp[nums1.length % 2][nums2.length];
    }

    //动态规划：dp[i][j]是nums1前i个元素 与 nums2前j个元素的最长公共字序列的长度
    static public int lcs2(int[] nums1 , int[] nums2) {
        if (nums1 == null || nums1.length == 0) return 0;
        if (nums2 == null || nums2.length == 0) return 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) { //最后一个元素是相等的，则是前i - 1个元素和前j - 1个元素的长度 + 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { //最后一个元素不相等，则去查找前i - 1个元素和前j个元素，以及前i个元素和前j - 1个元素的公共长度，
                    //取较大值
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }

    //递归
    static int lcs3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return 0;
        if (nums2 == null || nums2.length == 0) return 0;
        return lcs3(nums1,nums1.length , nums2,nums2.length);
    }

    /**
     * 函数：nums1的前i个元素和nums2的前j个元素的最长公共子序列的长度
     */
    static int lcs3(int[] nums1, int i , int[] nums2 , int j) {
        if ( i == 0 || j == 0) return 0;
        if (nums1[i - 1] == nums2[j - 1]) {
            return lcs3(nums1, i - 1,nums2,j - 1) + 1;
        }
        return Math.max(lcs3(nums1, i - 1,nums2,j),lcs3(nums1, i,nums2,j - 1));
    }
}
