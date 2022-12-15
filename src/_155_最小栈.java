import java.util.Deque;
import java.util.Stack;
import java.util.LinkedList;

 class MinStack {

	 public static void main(String[] args) {
		 MinStack minStack = new MinStack();
		 minStack.push(-2);
		 minStack.push(0);
		 minStack.push(-3);
		 minStack.getMin();//-3
		 minStack.pop();
		 minStack.top();
		 minStack.getMin();//-2
	 }

	 Stack<Integer> xStack;//正常栈
	 Stack<Integer> minStack; //最小栈

	 public MinStack() {
		 xStack = new Stack<Integer>();
		 minStack = new Stack<Integer>();
		 minStack.push(Integer.MAX_VALUE);//先push一个最大值，确保直接pop也没问题
	 }

	 public void push(int x) {
		 xStack.push(x);
		 minStack.push(Math.min(minStack.peek(), x));//比较栈顶和当前值，较小的才push进去
	 }

	 public void pop() {
		 xStack.pop();
		 minStack.pop();
	 }

	 public int top() {
		 return xStack.peek();
	 }

	 public int getMin() {//栈顶拿到最小值
		 System.out.println(minStack.peek());
		 return minStack.peek();
	 }
 }
