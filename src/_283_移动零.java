/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class _283_移动零 {
    /**
     * i是扫描，k是可以填充的位置，从0开始。填充了，k就++，填充完，后面的数都用0填充
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        int k = 0;
        //扫描一次，将非0的放到前面
        for(int x : nums) {
            if (x !=0) {
                nums[k] = x;
                k++;
            }
        }
        //再扫描一次，k后面的都填充0
        while (k < nums.length) {
            nums[k] = 0;
            k++;
        }
    }

    //填充：遇到0直接跳过，遇到非0，将当前的num[cur] = num[i], num[i] = 0，cur指的是非0的下标
    public void moveZeroes(int[] nums) {
        if (nums == null) return;
        for (int i = 0, cur = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (cur != i) {
                nums[cur] = nums[i]; //将i的值赋值给cur，同时i的值变成0
                nums[i] = 0;
            }
            cur++;
        }
    }
    
   //双指针：left指向第一个0的位置，right指向第一个非0的位置
    public void moveZeroes2(int[] nums) {
    	if (nums == null) return;
    	int left = 0;
    	int right = 0;
    	for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				swapNums(left , right,nums);
				left++;
			}
			right++;
		}
    }

    private void swapNums(int left , int right , int[] nums) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
}
