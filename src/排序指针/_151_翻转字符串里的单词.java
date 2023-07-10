package 排序指针;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 难度：中等
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
/*2023-7-10*/
public class _151_翻转字符串里的单词 {
	public static void main(String[] args) {
		System.out.println("666_" + reverseWords("") + "_666");
		System.out.println("666_" + reverseWords("  hello world!     ") + "_666");
		System.out.println("666_" + reverseWords("a good   example") + "_666");
		System.out.println("666_" + reverseWords("are you ok") + "_666");
	}

    public static String reverseWords(String s) {
    	if (s == null) return "";
    	char[] chars = s.toCharArray();
    	
    	// 消除多余的空格
    	// 字符串最终的有效长度
    	int len = 0;
    	// 当前用来存放字符的位置
    	int cur = 0;
    	// 为了防止多次放置空格，需要判断前一个字符是否为空格字符，如果前一个已经是空格了，就不要再放。
    	boolean space = true;
    	for (int i = 0; i < chars.length; i++) {
			if (chars[i] != ' ') { // chars[i]是非空格字符
				chars[cur++] = chars[i];
				space = false;
			} else if (space == false) { // chars[i]是空格字符，chars[i - 1]是非空格字符
				chars[cur++] = ' ';
				space = true;
			}
		}
		/*判断最后的字符是不是空格，如果是空格，就截去，获取有效字符串的长度*/
    	len = space ? (cur - 1) :cur;
    	if (len <= 0) return "";
    	

    	// 对整一个有效字符串进行逆序
    	reverse(chars, 0, len);
    	
    	// 对每一个单词进行逆序
    	// 前一个空格字符的位置
    	int prevSapceIdx = -1;
    	for (int i = 0; i < len; i++) {
			/*如果是字符，不需要动*/
			if (chars[i] != ' ') continue;
			// 遇到空格，得到一个完整的单词，去翻转
			reverse(chars, prevSapceIdx + 1, i);
			/*重置空格的位置*/
			prevSapceIdx = i;
		}
    	// 翻转最后一个单词
    	reverse(chars, prevSapceIdx + 1, len);
    	
    	return new String(chars, 0, len);
    }
    
    /**
     * 将[li, ri)范围内的字符串进行逆序
     */
    private static void reverse(char[] chars, int li, int ri) {
    	ri--;
    	while (li < ri) {
    		char tmp = chars[li];
    		chars[li] = chars[ri];
    		chars[ri] = tmp;
    		li++;
    		ri--;
    	}
    }
}
