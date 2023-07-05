package 字符串;

/**
 * https://leetcode.cn/problems/valid-palindrome/
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串
 */
/*2023-7-4*/
public class _125_验证回文串 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
   static public boolean isPalindrome(String s) {
        //转成小写字母
        String str = s.toLowerCase();
        StringBuilder builder = new StringBuilder();
        for (char c : str.toCharArray()) {
            //如果是字母或者数字，则拼接
            if (Character.isLetterOrDigit(c)) {
                builder.append(c);
            }
        }
        //比较builder 和 比较builder 是否相等
        return builder.toString().equals(builder.reverse().toString());
    }
}

