package 排序指针;

/**
 * https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class 剑指Offer10_I_斐波那契数列 {
    public static void main(String[] args) {
        System.out.println(fib4(6));
    }


    //滚动数组，优化迭代,空间复杂度降为O(1)
    public int fib3(int n) {
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i % 2] = array[(i - 1) % 2] + array[(i - 2) % 2];
        }
        return array[n % 2];
    }

    /*
     * 4 % 2 = 0  0b100 & 0b001 = 0
     * 3 % 2 = 1  0b011 & 0b001 = 1
     * 5 % 2 = 1  0b101 & 0b001 = 1
     * 6 % 2 = 0  0b110 & 0b001 = 0
     */

    //滚动数组，优化迭代,空间复杂度降为O(1),同时用&运算优化 % ，提高效率
    public int fib(int n) {
        if (n == 0) return 1;
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i & 1] = array[(i - 1) & 1] + array[(i - 2) & 1];
        }
        return array[n & 1];
    }

   static public int fib4(int n) {
        if (n == 0 ) return 0;
        if (n <= 2) return 1;
        int first = 1;
        int second = 1;
        for (int i = 3 ;i<= n; i++) {
            int temp = second % 1000000007; //保留上一次的值
            second = first % 1000000007 + second % 1000000007; //当前和
            first = temp;//前一次的和
        }
        return second % 1000000007;
    }

    //递归
    public int fib0(int n) {
        if (n <= 2) return 1;
        return fib0(n - 1) + fib0(n - 2);
    }

    //优化后的递归，去除了重复计算
    public int fib1(int n) {
        if (n <= 2) return 1;
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        return fib1(n, array);
    }

    public int fib1(int n, int[] array) {
        if (array[n] == 0) {
            array[n] = fib1(n - 1, array) + fib1(n - 2, array);
        }
        return array[n];
    }

    //迭代，O(n),O(n)
    public int fib2(int n) {
        if (n <= 2) return 1;
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }
}
