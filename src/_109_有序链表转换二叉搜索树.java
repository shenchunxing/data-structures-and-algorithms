import common.TreeNode;

/**
 * https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/
 */
public class _109_有序链表转换二叉搜索树 {
    //分治 + 中序遍历优化：O(n) O(logn)
    ListNode globalHead;
    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        return buildTree(0,getLength(head) - 1);
    }

    /**
     * 获取链表长度
     */
    private int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ret++;
            head = head.next;
        }
        return ret;
    }

    /**
     * 构建bst树：构造出的二叉搜索树的中序遍历结果就是链表本身，可以进行优化
     * 中序遍历的顺序：左 中 右
     */
    private TreeNode buildTree(int left , int right) {
        if (left > right) return null;//遍历到了空节点，退出递归
        int mid = (left + right + 1) / 2; //+1是为了兼容奇偶长度。确保在中间位置
        TreeNode root = new TreeNode();//root是一个占位节点，遍历到了该节点，才去赋值
        root.left = buildTree(left,mid - 1);//构建左子树
        root.val = globalHead.val; //遍历到了占位节点，则设值
        globalHead = globalHead.next;//每构建一个节点，则链表往下走一个
        root.right = buildTree(mid + 1,right);//构建右子树
        return root;
    }

    //分治：O(nlogn) O(logn)
    public TreeNode sortedListToBST1(ListNode head) {
        return buildTree(head,null);
    }

    /**
     * 构建bst树
     */
    private TreeNode buildTree(ListNode left , ListNode right) {
         if (left == right) return null; //递归出口
         ListNode mid = getMedia(left,right);
         TreeNode root = new TreeNode(mid.val);
         root.left = buildTree(left,mid); //递归构建左右子树
         root.right = buildTree(mid.next,right);
         return root;
    }

    /**
     * 快慢指针找到中间节点
     */
    private ListNode getMedia(ListNode left , ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right)  {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
