package leetcode;

import java.util.ArrayList;

/**
 * 反转链表
 * @author skywalker
 *
 */
public class ReverseList {

	public static void main(String[] args) {
		ListNode list = prepare();
		list = recursive(list);
		list.print();
	}
	
	/**
	 * 准备测试链表
	 */
	private static ListNode prepare() {
		ListNode head = new ListNode(1);
		ListNode ptr = head;
		ptr.next = new ListNode(2);
		ptr = ptr.next;
		ptr.next = new ListNode(3);
		ptr = ptr.next;
		ptr.next = new ListNode(4);
		return head;
	}
	
	/**
	 * 用循环的方式反转
	 * 2ms
	 * @param head
	 */
	@SuppressWarnings("unused")
	private static ListNode reverseList(ListNode head) {
		if (head != null) {
			ArrayList<ListNode> list = new ArrayList<>();
			ListNode node = head;
			while (node != null) {
				list.add(node);
				node = node.next;
			}
			int l = list.size() - 1;
			for (int i = l;i > 0;--i) {
				list.get(i).next = list.get(i - 1);
			}
			//因为第一个元素(反转后的最后一个)的next仍然指向最后一个，所以需要截断
			list.get(0).next = null;
			return list.get(l);
		}
		return null;
	}
	
	/**
	 * 用递归的方式实现，思路就是每次找到最后一个节点和倒数第二个节点，令最后一个指向倒数第二个
	 * ，特别注意要把倒数第二个的next置为null
	 * @param head 头结点
	 * @return 新的头结点
	 */
	private static ListNode recursive(ListNode head) {
		if (head != null) {
			ListNode pre = head;
			ListNode next = head.next;
			while (next != null && next.next != null) {
				pre = next;
				next = next.next;
			}
			//找到最后一个节点和倒数第二个节点
			if (next != null) {
				next.next = pre;
				pre.next = null;
				recursive(head);
			}
			return next;
		}
		return null;
	}
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		
		public void print() {
			ListNode node = this;
			while (node != null) {
				System.out.print(node.val + " ");
				node = node.next;
			}
		}
		
	}
	
}
