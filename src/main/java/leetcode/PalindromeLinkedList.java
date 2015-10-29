package leetcode;

import java.util.LinkedList;

/**
 * 判断链表是否是回文
 * @author skywalker
 *
 */
public class PalindromeLinkedList {

	//13ms
	private static boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		int length = length(head);
		LinkedList<Integer> stack = new LinkedList<Integer>();
		ListNode node = head;
		if (length % 2 == 0) {
			//偶数
			while (node != null) {
				if (!stack.isEmpty() && stack.peek() == node.val) {
					stack.pop();
				} else {
					stack.push(node.val);
				}
				node = node.next;
			}
			return stack.isEmpty();		
		} else {
			int mid = length / 2, index = 0;
			//奇数
			while (node != null) {
				if (index != mid) {
					if (!stack.isEmpty() && stack.peek() == node.val) {
						stack.pop();
					} else {
						stack.push(node.val);
					}
				}
				node = node.next;
				++index;
			}
			return stack.isEmpty();
		}
	}
	
	/**
	 * 求链表的长度
	 * @param head 非空
	 */
	private static int length(ListNode head) {
		int l = 1;
		ListNode node = head.next;
		while (node != null) {
			++l;
			node = node.next;
		}
		return l;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(ListNode.generateList(new int[] {1, 2, 3, 3, 2, 1})));
	}
	
}
