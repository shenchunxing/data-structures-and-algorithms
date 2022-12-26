/**
 * https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * 本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class 剑指Offer11_旋转数组的最小数字_中等_二分搜索 {
    public static void main(String[] args) {
        System.out.println(minArray(new int[] {3,4,5,6,7,1,1,2,2}));
    }

   static public int minArray(int[] numbers) {
         //nums可以被分割成2个数组，nums1里面的所有值都>=nums2里面的所有值
        int left = 0 , right = numbers.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (numbers[mid] > numbers[right]) { //mid在nums1中,最小值在nums2中
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) { //mid在nums2中，最小值在nums1中
                right = mid;
            } else { //因为存在重复元素，无法确定mid在哪个组
                right = right - 1; //缩小范围,不会丢失最小值
            }
        }
        return numbers[left];
    }

}
