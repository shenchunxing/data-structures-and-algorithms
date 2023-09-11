package 牛客网;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 双十一众多商品进行打折销售，小明想购买自己心仪的一些物品，但由于受购买资金限制，所以他决定从众多心仪商品中购买三件，而且想尽可能的花完资金。
 *
 * 现在请你设计一个程序帮助小明计算尽可能花费的最大资金数额。
 *
 * 输入描述:
 *
 * 输入第一行为一维整型数组M，数组长度小于100，数组元素记录单个商品的价格，单个商品价格小于1000。
 * 输入第二行为购买资金的额度R，R小于100000。
 * 输出描述:
 *
 * 输出为满足上述条件的最大花费额度。
 * 注意：
 *
 * 如果不存在满足上述条件的商品，请返回-1。
 *
 * 输入
 *
 * 23,26,36,27
 *
 * 78
 *
 * 输出
 *
 * 76
 */
public class 最大花费金额 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.next().split(",");
        String sum = sc.next();
        int[] arri = new int[arr.length];
        for (int i = 0; i <arr.length; i++) {
            arri[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(find(arri,arr.length,Integer.parseInt(sum)));
    }

    public static int find(int a[],int size,int sum) {
        List<Integer> result = new ArrayList<>();
        int left,right;
        Arrays.sort(a);
        /*选择3件*/
        for(int i=0;i<size-2;i++) {
            /*双指针逼近*/
            left=i+1;
            right=size-1;
            while(left<right) {
                /*找到一个可能的结果，left++*/
                if(a[i]+a[left]+a[right]<=sum) {
                    result.add(a[i]+a[left]+a[right]);
                    left++;
                }
                /*太大了，则right--*/
                else {
                    right--;
                }
            }
        }
        /*将所有结果从小排序，这里也可以用Match.abs存储最接近的值*/
        Collections.sort(result);
        /*最后那个是最接近的*/
        return result.get(result.size()-1);
    }
}
