/**
 * https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class 剑指Offer_51_数组中的逆序对 {
    int[] nums,temp ;
    public int reversePairs(int[] nums) {
        this.nums = nums;
        temp = new int[nums.length];
        return mergeSort(0,nums.length - 1);
    }

    //归并排序完成，逆序对也统计完成
    private int mergeSort(int l, int r) {
        if (l >= r) return 0;
        int m = (l + r) / 2;
        int res = mergeSort(l,m) + mergeSort(m + 1,r);
        //i、j代表当前的左、右子数组的位置
        int i = l , j = m + 1;
        //因为nums会被覆盖，需要临时存储从l到r的数据
        for (int k = l; k <= r; k++) {
            temp[k] = nums[k];
        }
        for (int k = l; k <= r ; k++) {
            if (i == m + 1) { //左子数组已经合并完，直接添加到右子数组中
                nums[k] = temp[j++];
            } else if (j == r + 1) { //右子数组已经合并完，直接添加到左子数组中
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) { //左小于右
                nums[k] = temp[i++];
            } else  {
                nums[k] = temp[j++]; //右小于左，构成了逆序对
                res +=  m - i + 1;//增加逆序对（当前i以后到m都大于j所在的位置）
            }
        }
        return res;
    }
}
