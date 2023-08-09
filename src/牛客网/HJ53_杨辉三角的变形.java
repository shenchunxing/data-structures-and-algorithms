package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数、左上角数和右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
 * 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3，输入2则输出-1。
 */
public class HJ53_杨辉三角的变形 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int row;
        while (line != null){
            row = Integer.parseInt(line);
            /*前面两行没有偶数*/
            if (row < 3){
                System.out.println(-1);
                /*剩余行数可以看出一些规律如下，多写几行就行*/
            } else if (row % 4 == 1 || row % 4 == 3){
                System.out.println(2);
            } else if (row % 4 == 0){
                System.out.println(3);
            } else {
                System.out.println(4);
            }
            line = reader.readLine();
        }
    }
}
