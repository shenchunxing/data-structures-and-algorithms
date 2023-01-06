package 字符串;

public class _125_验证回文串 {
    public boolean isPalindrome(String s) {
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
