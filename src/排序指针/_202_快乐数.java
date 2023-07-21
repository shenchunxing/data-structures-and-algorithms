package 排序指针;

import java.util.HashSet;

/**
 * https://leetcode.cn/problems/happy-number/
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false
 */
public class _202_快乐数 {
    /*如果不是快乐数，最后总是会回到以前的节点，相当于检测链表是否有环*/
    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy2(19));
        System.out.println(isHappy2(13));
        System.out.println(isHappy2(13));
    }

    //快慢指针法：检测链表是否有环 时间复杂度O(logn),空间复杂度O(1)
    static public boolean isHappy(int n) {
        int slow = n;//慢指针，每次走1步
        int fast  = getNext(n); //快指针，每次走2步
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;//如果是快乐数，fast首先到达1，不是快乐数，slow和fast在某处相遇。
    }

    //哈希表：检测是否有环 时间复杂度O(logn),空间复杂度O(logn)
    static public boolean isHappy2(int n) {
        HashSet<Integer> set = new HashSet<>();
        /*如果n != 1 && 哈希表没有出现过该数*/
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    /*19被分离出9^2 + 1^2 = 82*/
    static private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
}
