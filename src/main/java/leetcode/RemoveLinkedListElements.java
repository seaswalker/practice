package leetcode;

/**
 * 从链表中移除所有节点值为特定值的节点
 * @author skywalker
 *
 */
public class RemoveLinkedListElements {

	//1ms
	private static ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		ListNode pre = head, node = pre.next;
		while (node != null) {
			if (node.val == val) {
				pre.next = node.next;
				node = node.next;
			} else {
				pre = node;
				node = node.next;
			}
		}
		//处理头结点
		return head.val == val ? head.next : head;
	}
	
	public static void main(String[] args) {
		removeElements(ListNode.generateList(new int[] {1, 2, 3, 4, 5, 4}), 4).print();
	}
	
}
