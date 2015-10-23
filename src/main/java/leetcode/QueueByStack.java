package leetcode;

import java.util.LinkedList;

/**
 * 用栈实现队列的push pop peek() empty()操作
 * 只可以使用栈的pop/push/peek, size(), isEmpty()方法
 * 思路就是，每次push都向empty栈push，取的时候从full取，如果full没有元素了，那么把empty的全部压入full
 * @author skywalker
 *
 */
public class QueueByStack<E> {

	private LinkedList<E> empty = new LinkedList<E>();
	private LinkedList<E> full = new LinkedList<E>();
	
	public void push(E e) {
		empty.push(e);
	}
	
	//leetcode的要求这个没有返回值
	public E pop() {
		merge();
		return full.pop();
	}
	
	public E peek() {
		merge();
		return full.peek();
	}
	
	public boolean empty() {
		return full.isEmpty() && empty.isEmpty();
	}
	
	private void merge() {
		if (full.isEmpty()) {
			//把empty栈的元素全部加入full
			while (!empty.isEmpty()) {
				full.push(empty.pop());
			}
		}
	}
	
	public static void main(String[] args) {
		QueueByStack<String> queue = new QueueByStack<String>();
		queue.push("A");
		queue.push("B");
		queue.push("C");
		queue.push("D");
		System.out.println(queue.pop());
		queue.push("E");
		while (!queue.empty()) {
			System.out.print(queue.pop() + " ");
		}
	}
	
}
