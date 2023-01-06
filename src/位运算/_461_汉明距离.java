package 位运算;

/**
 * https://leetcode-cn.com/problems/hamming-distance/
 * @author shenchunxing
 *
 */
public class _461_汉明距离 {

	public int hammingDistance(int x, int y) {
       return Integer.bitCount(x ^ y);
    }
	
	public int hammingDistance2(int x, int y) {
	       int res = 0;
	       int s = x ^ y; //异或
	       while (s != 0) {
			  res += s & 1; //计算1的数量
			  s = s>> 1; //右移1位
		   }
	       return res;
	  }
}
