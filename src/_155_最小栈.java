import java.util.Stack;

 class MinStack {
		private Stack<Integer> stack;
		private Stack<Integer> minStack;
		
		public  MinStack() {
		    	stack = new Stack<>();
		    	minStack = new Stack<>();
		    }
		    
		public  void push(int val) {
		    	stack.push(val);
		    	if (minStack.isEmpty()) {
		    		minStack.push(val);
		    	} else {
					 minStack.push(Math.min(stack.peek(), minStack.pop()));
				}
		    }
		    
		public  void pop() {
		    	stack.pop();
		    	minStack.pop();
		    }
		    
		public int top() {
		    	return stack.peek();
		    }
		    
		public  int getMin() {
		    	return minStack.peek();
		    }
		
		
		
		/**
		 * 虚拟头节点
		 */
		public static class Node {
			public Node(int value, int min, Node next) {
				this.value = value;
				this.min = min;
				this.next = next;
			}
			int value;
			int min;
			Node next;
			
			
		}
		
		
		
		}
