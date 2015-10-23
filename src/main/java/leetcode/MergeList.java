package leetcode;

/**
 * 合并两个已排好序的链表
 * @author skywalker
 *
 */
public class MergeList {
	
	//1ms
	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else {
			ListNode result;
			ListNode f, s;
			//确定头结点
			if (l1.val < l2.val) {
				result = l1;
				f = l1.next;
				s = l2;
			} else {
				result = l2;
				s = l2.next;
				f = l1;
			}
			ListNode ptr = result;
			while (f != null && s != null) {
				if (f.val < s.val) {
					ptr.next = f;
					f = f.next;
				} else {
					ptr.next = s;
					s = s.next;
				}
				ptr = ptr.next;
			}
			//继续连接比较长的链表的后面
			while (f != null) {
				ptr.next = f;
				ptr = ptr.next;
				f = f.next;
			}
			while (s != null) {
				ptr.next = s;
				ptr = ptr.next;
				s = s.next;
			}
			return result;
		}
    }
	
	private static ListNode generate(int[] nums) {
		ListNode head = new ListNode(nums[0]);
		ListNode ptr = head;
		for (int i = 1, l = nums.length;i < l;++i) {
			ptr.next = new ListNode(nums[i]);
			ptr = ptr.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		ListNode l1 = generate(new int[] {1, 3, 5, 7});
		ListNode l2 = generate(new int[] {2, 4, 6, 8});
		mergeTwoLists(l1, l2).print();
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
