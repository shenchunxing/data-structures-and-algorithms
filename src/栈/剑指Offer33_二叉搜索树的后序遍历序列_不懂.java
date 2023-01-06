package 栈;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 */
public class 剑指Offer33_二叉搜索树的后序遍历序列_不懂 {
    public static void main(String[] args) {
        /**
         *     5
         *   2   6
         * 1  3
         */
        System.out.println(verifyPostorder1(new int[] {1,3,2,6,5}));
    }

    //单调栈:后序遍历的倒序 5 6 2 3 1,按照根、右、左的顺序
    //O(n) O(n)
    static public boolean verifyPostorder1(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0 ; i--) {
            if (postorder[i] > root) return false;
            //如果当前扫描元素 > root。则是root的右子树，直接入栈即可
            //如果当前扫描元素 < root。则是root的左子树，则一直出栈，找到第一个 > root的就是该左子树的根节点
            //为了去满足二叉搜索树的性质
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }

    //O(n^2) O(n)
    static public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length - 1);
    }

    /**
     * 后序遍历，end是根节点，start查找的开始位置
     * @param postorder
     * @param start
     * @param end
     * @return
     */
    static boolean recur(int[] postorder,int start , int end) {
        if (start >= end) return true; //子树节点 <= 1,返回true
        int p = start;
        while (postorder[p] < postorder[end]) {
            p++;
        }
        int m = p;
        //此时p所在的位置就是第一个大于end的值，用于区分左右子树
        //可以拿到左子树的范围是[start,m - 1)
        while (postorder[p] > postorder[end]) {
            p++;
        }
        //此时p所在的位置就是end的位置，可以拿到右子树的范围是[m,end - 1)
        //p == end，判断此树是否正确
        //recur(postorder,start, m - 1)判断左子树是否正确
        // recur(postorder,m , end - 1)判断右子树是否正确
        return p == end && recur(postorder,start, m - 1) && recur(postorder,m , end - 1);
    }
}
