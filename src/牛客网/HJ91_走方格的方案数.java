package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/4
 * 请计算n*m的棋盘格子（n为横向的格子数，m为竖向的格子数）从棋盘左上角出发沿着边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 */
public class HJ91_走方格的方案数 {
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ReaderString;
        while ((ReaderString = reader.readLine())!=null){
            String[] ReaderSplit = ReaderString.split(" ");
            int n = Integer.parseInt(ReaderSplit[0]);
            int m = Integer.parseInt(ReaderSplit[1]);
            System.out.println(getCount(n,m));
        }
    }

    public static int getCount(int n,int m) {
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n+1;i++) {
            for(int j=0;j<m+1;j++) {
                if(i==0||j==0){
                    // 边上的每一个点的可能性都是1，因为走到边上，就只能顺着边往下走了，可能性只能是1
                    dp[i][j]=1;
                }else{
                    // 往后每一个点，都是后面两个点的可能性之和，因为它可以选择任意一个点来走，可能性就是下两个点的可能性相加
                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }
            }
        }
        // 最终加到最后一个点，可能性就是所有的路线数量
        return dp[n][m];
    }
}
