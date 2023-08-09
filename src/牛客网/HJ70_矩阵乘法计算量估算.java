package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/4
 * 描述
 * 矩阵乘法的运算量与矩阵乘法的顺序强相关。
 * 例如：
 *
 * A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
 *
 * 计算A*B*C有两种顺序：((AB)C)或者(A(BC))，前者需要计算15000次乘法，后者只需要3500次。
 *
 * 编写程序计算不同的计算顺序需要进行的乘法次数。
 *
 * 数据范围：矩阵个数：1\le n\le 15 \1≤n≤15 ，行列数：1\le row_i,col_i\le 100\1≤row
 * i
 * ​
 *  ,col
 * i
 * ​
 *  ≤100 ，保证给出的字符串表示的计算顺序唯一。
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
 *
 * 输入描述：
 * 输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，最后输入要计算的法则
 * 计算的法则为一个字符串，仅由左右括号和大写字母（'A'~'Z'）组成，保证括号是匹配的且输入合法！
 *
 * 输出描述：
 * 输出需要进行的乘法次数
 */
public class HJ70_矩阵乘法计算量估算 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            int num = Integer.parseInt(str);
            /*arr存储矩阵信息*/
            int [][] arr = new int[num][2];

            for(int i = 0;i<num;i++) {
                String [] sa = br.readLine().split(" ");
                arr[i][0] = Integer.parseInt(sa[0]);
                arr[i][1] = Integer.parseInt(sa[1]);
            }

            int n = arr.length -1;
            /*计算法则比如(A(BC))*/
            char [] ca = br.readLine(). toCharArray();
            Stack<Integer> stack = new Stack<>();
            int sum = 0;
            for(int i = ca.length - 1;i>=0;i--) {
                char one = ca[i];
                /*右括号*/
                if(one == ')') {
                    stack.push(-1);
                    /*左括号*/
                }else if(one == '(') {
                    /*索引*/
                    int n1 = stack.pop();
                    int n2 = stack.pop();
                    /*第一个矩阵的行 * 第二个矩阵的行 *第二个矩阵的列 */
                    sum+= arr[n1][0]*arr[n2][0]*arr[n2][1];
                    /*第一个矩阵的列 = 第二个矩阵的列*/
                    arr[n1][1] = arr[n2][1];
                    stack.pop();
                    stack.push(n1);
                    /*字母*/
                }else {
                    stack.push(n);
                    n--;
                }
            }
            System.out.println(sum);
        }
    }
}
