package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * {@link offer.Queue}反过来，
 * 用两个队列实现栈
 * @author skywalker
 *
 */
public class Stack<T> {

	private Queue<T> queueA = new LinkedList<T>();
	private Queue<T> queueB = new LinkedList<T>();
	
	/**
	 * 每次都是向非空的队列里面加入新元素
	 */
	public void push(T t) {
		if(!queueA.isEmpty()) {
			queueA.offer(t);
		}else {
			queueB.offer(t);
		}
	}
	
	/**
	 * 每次从非空队列里面把前n - 1个元素放入空队列
	 * 剩下的最后一个就是队尾/栈顶元素
	 */
	public T pop() {
		Queue<T> empty = (queueA.isEmpty()) ? queueA : queueB;
		Queue<T> notEmpty = (queueA.isEmpty()) ? queueB : queueA;
		int size = notEmpty.size();
		for(int i = 1;i < size;i ++) {
			empty.offer(notEmpty.poll());
		}
		return notEmpty.poll();
	}
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("first");
		stack.push("second");
		stack.push("third");
		for(int i = 0;i < 3;i ++) {
			System.out.println(stack.pop());
		}
	}
	
}
