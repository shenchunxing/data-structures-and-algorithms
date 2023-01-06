package 排序指针;

/**
 * https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/
 * 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 * 字典序是从第一位开始比较的
 * [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]
 */
public class _440_字典序的第K小数字 {
    public static void main(String[] args) {
        _440_字典序的第K小数字 o = new _440_字典序的第K小数字();
        System.out.println(o.findKthNumber(13,3));
    }
    public int findKthNumber(int n, int k) {
        int curr = 1;// 当前遍历到的数字，从1（根）出发
        k--;// 从1出发开始往后按字典序从小到大的顺序走k-1步到达的就是 字典序的第K小数字
        while (k > 0) {
            int steps = getSteps(curr, n);
            if (steps <= k) { // 向右侧节点走：字典序上升nodes位
                k -= steps;
                curr++;// 当前数字 cur = cur + 1
            } else { // 向下往最左孩子节点走:字典序上升1位
                curr = curr * 10; // 当前数字 cur = cur * 10
                k--;
            }
        }
        return curr;
    }
    // 计算以curr为根的子树节点数目，所有节点的值必须 <= n
    public int getSteps(int curr, long n) {
        int steps = 0;// 记录子树中的全部节点数目
        long first = curr;
        long last = curr;
        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return steps;
    }
}
