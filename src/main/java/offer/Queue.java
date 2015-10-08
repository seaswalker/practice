package offer;

import java.util.Stack;

/**
 * 面试题7：用两个栈实现队列的appendTail()和popHead()操作
 * 思路是：
 * 首先把所有的元素压入栈A，如果B为空，就把A的元素全部压入B，这时就把顺序变为了先进先出
 * 取元素都是从B里面取
 * @author skywalker
 *
 */
public class Queue<T> {

	/**
	 * 不要打我，我用Stack了
	 */
	private Stack<T> stackA = new Stack<T>();
	private Stack<T> stackB = new Stack<T>();
	
	/**
	 * 获得队列的头元素
	 */
	public T popHead() {
		if(stackB.empty()) {
			push2B();
		}
		return stackB.empty() ? null : stackB.pop();
	}
	
	/**
	 * 向尾巴上加内容
	 */
	public void appendTail(T t) {
		stackA.push(t);
	}
	
	/**
	 * 把A中的元素全部压入到B中
	 */
	private void push2B() {
		while(!stackA.empty()) {
			stackB.push(stackA.pop());
		}
	}
	
	public static void main(String[] args) {
		Queue<String> queue = new Queue<String>();
		queue.appendTail("first");
		queue.appendTail("second");
		queue.appendTail("tail");
		
		/**
		 * 结果正确
		 * first
		 * second
		 * tail
		 */
		for(int i = 0;i < 4; ++i) {
			System.out.println(queue.popHead());
		}
	}
	
}
