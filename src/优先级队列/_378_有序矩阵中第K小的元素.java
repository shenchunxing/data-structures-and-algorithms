package 优先级队列;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class _378_有序矩阵中第K小的元素 {
    public static void main(String[] args) {
        System.out.println(kthSmallest2(new int[][] {
                {1,5,9},{10,11,13},{12,13,15}
        },8));
    }

    //二分搜索
    static public int kthSmallest2(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[row - 1][col - 1];
        while (left < right) {
            // 每次循环都保证第K小的数在start~end之间，当start==end，第k小的数就是start
            int mid = (left + right) / 2;
            // 找二维矩阵中<=mid的元素总个数
            int count = findNotBiggerThanMid(matrix, mid, row, col);
            if (count < k) {
                // 第k小的数在右半部分，且不包含mid
                left = mid + 1;
            } else {
                // 第k小的数在左半部分，可能包含mid
                right = mid;
            }
        }
        return right;
    }

    static private int findNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
        // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
        int i = row - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {
                // 第j列有i+1个元素<=mid
                count += i + 1;
                j++;
            } else {
                // 第j列目前的数大于mid，需要继续在当前列往上找
                i--;
            }
        }
        return count;
    }


    //优先级队列，维护一个大小为k的大顶堆，堆顶元素就是第k小的元素
    static public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                heap.add(matrix[i][j]);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }
        return heap.peek();
    }
}
