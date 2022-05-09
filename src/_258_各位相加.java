
/**
 * https://leetcode-cn.com/problems/add-digits/
 * @author shenchunxing
 *
 */
public class _258_各位相加 {
	
	public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
