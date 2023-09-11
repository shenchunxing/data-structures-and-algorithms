package 牛客网;

import java.util.Scanner;

/**
 * 有一名科学家想要从一台古董电脑中拷贝文件到自己的电脑中加以研究。
 *
 * 但此电脑除了有一个3.5寸软盘驱动器以外，没有任何手段可以将文件持贝出来，而且只有一张软盘可以使用。
 *
 * 因此这一张软盘是唯一可以用来拷贝文件的载体。
 *
 * 科学家想要尽可能多地将计算机中的信息拷贝到软盘中，做到软盘中文件内容总大小最大。
 *
 * 已知该软盘容量为1474560字节。文件占用的软盘空间都是按块分配的，每个块大小为512个字节。一个块只能被一个文件使用。拷贝到软盘中的文件必须是完整的，且不能采取任何压缩技术。
 *
 * 输入描述
 *
 * 第1行为一个整数N，表示计算机中的文件数量。1 ≤ N ≤ 1000.
 * 接下来的第2行到第N+1行(共N行)，每行为一个整数，表示每个文件的大小Si，单位为字节。
 *
 * 0 ≤ i < N,0 ≤ Si
 *
 * 输出描述
 *
 * 科学家最多能拷贝的文件总大小
 */
public class 通过软盘拷贝文件 {
    /*其实就是背包问题*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(getResult(n, arr));
    }
    public static int getResult(int n, int[] arr) {
        /*软盘可以被分割成多少块*/
        int bag = 1474560 / 512; // 背包承重（块）
        int[] dp = new int[bag + 1];
        for (int i = 0; i < n; i++) {
            /*每个文件需要占用多少块*/
            int weight = (int) Math.ceil(arr[i] / 512.0); // 物品的重量（块）
            int worth = arr[i]; // 物品的价值（字节）

            /*文件arr[i]至少需要占用weight个块才能完成拷贝，则剩余磁盘就是j - weight，当前的拷贝总量 = dp[j - weight] + worth*/
            for (int j = bag; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + worth);
            }
        }
        return dp[bag];
    }
}
