import java.util.Deque;
import java.util.Stack;
import java.util.LinkedList;

 class MinStack {
	 Stack<Integer> xStack;
	 Stack<Integer> minStack; //最小栈

	 public MinStack() {
		 xStack = new Stack<Integer>();
		 minStack = new Stack<Integer>();
		 minStack.push(Integer.MAX_VALUE);
	 }

	 public void push(int x) {
		 xStack.push(x);
		 minStack.push(Math.min(minStack.peek(), x));
	 }

	 public void pop() {
		 xStack.pop();
		 minStack.pop();
	 }

	 public int top() {
		 return xStack.peek();
	 }

	 public int min() {
		 return minStack.peek();
	 }
 }
