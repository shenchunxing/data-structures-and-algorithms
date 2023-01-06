package 数学;

public class _268_丢失的数字 {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] {1,2,3}));
        System.out.println(missingNumber(new int[] {3,0,1}));
    }

    //求和
   static public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int sum2 = 0;
        for (int num : nums) {
            sum2 += num;
        }
        return sum - sum2;
    }
}
