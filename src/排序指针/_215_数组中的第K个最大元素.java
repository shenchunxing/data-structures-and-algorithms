package 排序指针;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 * 难度：中等
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
/*2023-7-11 不理解*/
public class _215_数组中的第K个最大元素 {
    /*为了让长度随机，用于生成随机数。时间平均后复杂度是O(n)*/
    Random random = new Random();

    /*返回数组中第k大的元素*/
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    /**
     * 实现了快速选择算法，用于在数组中查找第k大的元素。
     * 传入的参数包括数组 a、当前子数组的左边界 l、右边界 r，以及第k大的元素在子数组中的索引 index。
     */
    public int quickSelect(int[] a, int l, int r, int index) {
        /*调用 randomPartition 方法进行随机化分区，得到基准元素的位置 q*/
        int q = randomPartition(a, l, r);
        /*如果 q 等于 index，说明找到了第k大的元素，直接返回数组中的该元素 a[q]。*/
        if (q == index) {
            return a[q];
            /*根据基准元素的位置 q 和目标位置 index 的关系，决定从左侧还是右侧进行递归查找。
            如果 q < index，说明第k大的元素在右侧子数组中，调用 quickSelect 方法递归查找右侧子数组；
            否则，调用 quickSelect 方法递归查找左侧子数组。*/
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    /*首先随机选择一个位置 i，将其与右边界 r 上的元素进行交换，然后调用 partition 方法进行分区，得到基准元素的位置。*/
    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    /*用于进行分区操作，选择最右边界上的元素 x 作为基准元素，遍历子数组，将小于等于基准元素的元素交换到左侧，大于基准元素的元素交换到右侧，
    最后将基准元素放置到正确的位置上。*/
    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
