public class _191_位1的个数 {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n = n & (n - 1); //n & (n - 1)每次可以把n的二进制位的最低位的1变成0
        }
        return sum;
    }
}
