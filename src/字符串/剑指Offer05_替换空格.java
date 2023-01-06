package 字符串;

/**
 * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 */
public class 剑指Offer05_替换空格 {
    public static void main(String[] args) {
        System.out.println(replaceSpace1("s xx jk"));
    }
    static public String replaceSpace1(String s) {
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (c == ' ') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    static public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3]; //直接创建3倍大小，有点浪费内存。
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') { //如果是空格，则将空格替换成"%20"，size+3
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else  {
                array[size++] = c;
            }
        }
        return new String(array,0,size);
    }
}
