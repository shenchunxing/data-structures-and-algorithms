public class _191_位1的个数 {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n = n & (n - 1); //
        }
        return sum;
    }
}
