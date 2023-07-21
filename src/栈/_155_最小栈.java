package 栈;

import java.util.Stack;


/**
 * https://leetcode.cn/problems/min-stack/
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 */
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
		 minStack.push(Integer.MAX_VALUE);//先push一个最大值，确保没有push的情况下，直接pop也没问题
	 }

	 public void push(int val) {
		 xStack.push(val);
		 minStack.push(Math.min(minStack.peek(), val));//比较栈顶和当前值，较小的才push进去
	 }

	 public void pop() {
		 xStack.pop();
		 minStack.pop();
	 }

	 public int top() {
		 return xStack.peek();
	 }

	 public int getMin() {//栈顶拿到最小值
		 return minStack.peek();
	 }
 }
