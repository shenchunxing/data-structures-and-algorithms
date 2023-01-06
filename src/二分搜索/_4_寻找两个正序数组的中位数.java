package 二分搜索;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class _4_寻找两个正序数组的中位数 {
    /**
     * 二分搜索
     * 可以转化成寻找两个有序数组中的第k小的数 k = (m + n) / 2 或者 (m + n) / 2 + 1
     * 比较nums1[k/2 - 1] 和 nums2[k/2 - 1]的大小，假设nums2较小，则nums1[k/2 - 1]前k/2 - 1个元素和
     * nums2[k/2 - 1]前k/2 - 1个元素 求和等于k -2 ,说明最多只有k-2个元素，nums2[0]到nums2[k/2 - 1]可以全部排除，
     * 她们不会是中位数
     * 原理：每轮循环排除一半较小的元素，逐渐逼近第k小的元素
     * A: 1 3 4 9
     * B: 1 2 3 4 5 6 7 8 9
     * 长度和为13，中位数是第7个元素
     * 比较k/2 - 1 = 2，A[2] > B[2] 直接排除了B里面的1 2 3 ，同时更新k = k - k/2 = 4
     * 比较k/2 - 1 = 1，A[1] < B[4] 直接排除了A里面的1 3 ，同时更新k = k - k/2 = 2
     * 比较k/2 - 1 = 0，A[2] = B[3] 直接排除了A里面的4 ，同时更新k = k - k/2 = 1
     * k已经是1，直接比较剩余的两个数组中较小的那个就行，A[3] = 9 > B[3] = 4 ，所以中位数是4
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length,length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) { //奇数和
            int midIndex = totalLength / 2;
            return getKthElement(nums1,nums2,midIndex + 1);//直接取最中间
        } else { //偶数和
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            return (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
        }
    }

    /**
     * 从数组中找到第k小的数字
     */
    private int getKthElement(int[] nums1 , int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0; //index1、index2分别表示排除后，数组最小的值的下标
        while (true) {
            //边界
            //表示nums1数组已经全部被排除了，第k小的在nums2数组中，直接取
            if (index1 == length1) return nums2[index2 + k - 1];
            //表示nums2数组已经全部被排除了，第k小的在nums1数组中，直接取
            if (index2 == length2) return nums1[index1 + k - 1];
            //k == 1说明前k - 1个元素已经被排除出去了，只剩下第k个元素了。直接取小的就行
            if (k == 1) return Math.min(nums1[index1],nums2[index2]);

            //正常情况
            int half = k / 2; //减半比较
            int newIndex1 = Math.min(index1 + half,length1) - 1;//排除后，新的下标位置,这里取较小值是为了防止数组越界？
            int newIndex2 = Math.min(index2 + half,length2) - 1;
            int pivot1 = nums1[newIndex1],pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;//nums1前k/2 - 1个元素被排除出去
            } else  {
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}

