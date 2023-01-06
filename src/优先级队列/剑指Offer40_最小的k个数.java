package 优先级队列;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
 */
public class 剑指Offer40_最小的k个数 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getLeastNumbers2(new int[] {2,5,6,3,8,9,7},3)));
    }
    //堆：o(logK)
    static public int[] getLeastNumbers2(int[] arr, int k) {
        if(k == 0 || arr.length == 0 ) return new int[0];
        //大顶堆
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int num : arr) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (queue.peek() > num) { //堆顶更大，则需要重新建堆
                queue.poll();
                queue.offer(num);
            }
        }
        int[] ans = new int[queue.size()];
        int idx = 0;
        for (int num : queue) {
            ans[idx++] = num;
        }
        return ans;
    }

    //基于快速排序的数组划分O(n) O(logN)
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) return arr;
        return quickSort2(arr,k,0,arr.length - 1);
    }

    //快速排序O(logN) O(n)
    public int[] getLeastNumbers1(int[] arr, int k) {
        quickSort(arr,0,arr.length - 1);
        return Arrays.copyOf(arr,k);//获取前k个元素
    }

    //优化后的快速排序:如果某次排序排序后，哨兵正好是第k+1小的数组，则哨兵左侧的就是第k小的数集合
    private int[] quickSort2(int[] arr , int k, int l ,int r) {
        int i = l , j = r; //哨兵划分：以arr[l]为基准数
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;//大于哨兵的值放右边
            while (i < j && arr[i] <= arr[l]) i++;//小于哨兵的值放左边
            swap(arr,i,j);//左右各自找到了一个不符合序列的值，交换后，双方都符合了。
        }
        swap(arr,i,l);//此时交换更小的arr[i]到左边，整体趋势是向有序接近
        if (i > k) return quickSort2(arr, k, l , i - 1); //排序从l到i - 1的位置
        if (i < k) return quickSort2(arr, k,i + 1,r);//排序从i + 1到r的位置
        return Arrays.copyOf(arr,k); //说明i == k，则直接返回左侧的排序数组
    }

    /**
     * 排序从l到r
     * @param arr
     * @param l
     * @param r
     */
    private void quickSort(int[] arr , int l ,int r) {
        if (l >= r) return; //子数组长度为1的时候，结束递归
        int i = l , j = r; //哨兵划分：以arr[l]为基准数
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;//大于哨兵的值放右边
            while (i < j && arr[i] <= arr[l]) i++;//小于哨兵的值放左边
            swap(arr,i,j);//左右各自找到了一个不符合序列的值，交换后，双方都符合了。
        }
        swap(arr,i,l);//此时交换更小的arr[i]到左边，整体趋势是向有序接近
        quickSort(arr, l , i - 1); //排序从l到i - 1的位置
        quickSort(arr,i + 1,r);//排序从i + 1到r的位置
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //计数排序O(n)，O(n)
    public int[] getLeastNumbers3(int[] arr, int k) {
        if (k == 0 || arr == null || arr.length == 0) return new int[0];
        int[] counter = new int[10001];
        for (int num : arr) {
            counter[num]++; //统计每个数字出现的次数,从0到10000
        }
        int[] res = new int[k];
        int idx = 0;
        //根据counter数组，从头找出k个数作为返回结果
        for (int num = 0 ; num < counter.length ;num ++) {
            while (counter[num]-- > 0 && idx < k) {
                res[idx++] = num; //从数组中一个个取出来，直到取完k个数。
            }
            if (idx == k) break;//已经选完了
        }
        return res;
    }
}
