package leetcode;

public class MinStack {
	
	private int[] values = new int[100000];
	//栈顶指针
	private int top = 0;

	public void push(int x) {
		values[top++] = x;
	}

	public void pop() {
		if (top > 0) {
			--top;
		}
	}

	public int top() {
		return values[top - 1];
	}

	public int getMin() {
		int min = values[0];
		for (int i = 1;i < top; ++i) {
			if (values[i] < min) {
				min = values[i];
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.top());
		stack.pop();
		stack.push(3);
		System.out.println(stack.top());
	}

}
