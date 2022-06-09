import java.util.ArrayDeque;
import java.util.Deque;

public class _71_简化路径 {
    public static void main(String[] args) {
        _71_简化路径 o = new _71_简化路径();
//        System.out.println(o.simplifyPath("/home/"));
//        System.out.println(o.simplifyPath("/../"));
//        System.out.println(o.simplifyPath("/home//foo/"));
        System.out.println(o.simplifyPath("/a/./b/../../c/"));
    }
    public String simplifyPath(String path) {
        //根据"/"分割成数组
        String[] names = path.split("/");
        //双端队列，从头尾都可以操作
        Deque<String> stack = new ArrayDeque<>();
        for (String name : names) { //如果是一个点或者空字符串，什么都不需要做
            if ("..".equals(name)) { //如果是两个点，需要切换目录，弹出栈顶元素
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
                //name.length() > 0 过滤了空字符串
            } else if (name.length() > 0 && !name.equals(".")) { //如果是目录，入栈
                stack.offerLast(name);
            }
        }
        StringBuilder builder = new StringBuilder();
        if (stack.isEmpty()) { //如果栈是空的，直接拼接"/"
            builder.append("/");
        } else {
            while (!stack.isEmpty()) { //栈底到栈顶用"/"连接。在最前面加上"/"
                builder.append("/");
                builder.append(stack.pollFirst());
            }
        }
        return builder.toString();
    }
}
