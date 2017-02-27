package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 用队列实现栈
 * 思路就是每次取数据时把full中的前size() - 1个元素加入empty栈，那么full中剩下的就是栈顶元素
 * @author skywalker
 *
 */
public class StackByQueue {

	private Queue<Integer> empty = new ArrayDeque<Integer>();
	private Queue<Integer> full = new ArrayDeque<Integer>();
	private Queue<Integer> temp;
	/**
	 * 辅助判断上一步操作是否是push，如果是，由于需要先弹出此元素，所以
	 * 必定要执行那一次merge操作
	 */
	private boolean push = false;

	public void push(int x) {
		// 加入到非空的队列
		full.offer(x);
		push = true;
	}

	public void pop() {
		if (push || empty.isEmpty()) {
			merge();
		}
		empty.poll();
		push = false;
	}

	public int top() {
		if (push || empty.isEmpty()) {
			merge();
		}
		push = false;
		return empty.peek();
	}

	public boolean empty() {
		return full.isEmpty() && empty.isEmpty();
	}

	private void merge() {
		int size = full.size(), i = 1;
		while (i++ < size) {
			empty.offer(full.poll());
		}
		temp = empty;
		empty = full;
		full = temp;
	}

	public static void main(String[] args) {
		StackByQueue stack = new StackByQueue();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.top());
		stack.pop();
		stack.pop();
		System.out.println(stack.empty());
	}

}
