package leetcode;

/**
 * 移除链表的倒数第n个节点
 * @author skywalker
 *
 */
public class RemoveNthNodeFromEndofList {

	/**
	 * Try to do this in one pass
	 * 1ms
	 * 思路就是设置两个游标，一个领先另一个n步，你懂的
	 * @param head
	 * @param n 总是合法的
	 * @return 返回新的头结点
	 */
	private static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		ListNode f = head, s = head, pre = null;
		for (int i = 0;i < n; ++i) {
			s = s.next;
		}
		while (s != null) {
			pre = f;
			f = f.next;
			s = s.next;
		}
		//移除的是头结点
		if (pre == null) {
			return f.next;
		} else {
			pre.next = f.next;
			return head;
		}
	}
	
	public static void main(String[] args) {
		removeNthFromEnd(ListNode.generateList(new int[] {1, 2, 3, 4, 5}), 5).print();;
	}
	
}
