package leetcode;

/**
 * 交换两个相邻的节点
 * 
 * @author skywalker
 *
 */
public class SwapNodesInPair {

	public static ListNode swapPairs(ListNode head) {
		if (head == null) return null;
		ListNode pre = null, newHead = null;
		ListNode cur = head,
				n = head.next;
		newHead = n == null ? head : n;
		while (cur != null && n != null) {
			cur.next = n.next;
			n.next = cur;
			if (pre != null) {
				pre.next = n;
			}
			pre = cur;
			cur = cur.next;
			if (cur == null) break;
			n = cur.next;
		}
		return newHead;
	}
	
	public static void main(String[] args) {
		ListNode head = swapPairs(ListNode.generateList(new int[] {1, 2, 3, 4, 5, 6, 7}));
		head.print();
	}

}
