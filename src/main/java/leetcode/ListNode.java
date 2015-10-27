package leetcode;

public class ListNode {

	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
	
	/**
	 * 把自己打印出来
	 */
	void print() {
		ListNode node = this;
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
	
	@Override
	public String toString() {
		return "ListNode [val=" + val + "]";
	}

	/**
	 * 根据节点数组创建链表
	 * @param nodes 节点数组
	 * @return 头结点
	 */
	static ListNode generateList(int[] nodes) {
		if (nodes != null && nodes.length > 0) {
			ListNode head = new ListNode(nodes[0]);
			ListNode ptr = head;
			for (int i = 1, l = nodes.length;i < l;++i) {
				ptr.next = new ListNode(nodes[i]);
				ptr = ptr.next;
			}
			return head;
		}
		return null;
	}
	
}
