package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 寻找两个链表的交叉点
 * Note:
 * 1. 如果没有交叉点，返回null
 * 2. 不能改变链表的原有结构
 * 3. 没有环
 * 4. 时间复杂度O(n), 空间复杂度O(1)
 * @author skywalker
 *
 */
public class IntersectionofTwoLinkedLists {

	//当链表的长度为2002时超时
	//O(n x m)
	@SuppressWarnings("unused")
	private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA != null && headB != null) {
        	ListNode f = headA.next, s = headB.next;
        	while (f != null) {
        		while (s != null) {
        			if (s == f) {
        				return s;
        			}
        			s = s.next;
        		}
        		f = f.next;
        		s = headB.next;
        	}
        }
        return null;
    }
	
	/**
	 * 改进算法
	 * 5ms
	 */
	private static ListNode improve(ListNode headA, ListNode headB) {
		if (headA != null && headB != null) {
			List<ListNode> as = new ArrayList<ListNode>();
			ListNode a = headA;
			while (a != null) {
				as.add(a);
				a = a.next;
			}
			List<ListNode> bs = new ArrayList<ListNode>();
			ListNode b = headB;
			while (b != null) {
				bs.add(b);
				b = b.next;
			}
			int aIndex = as.size() - 1, bIndex = bs.size() - 1;
			//是否有交集
			boolean found = false;
			while (aIndex >= 0 && bIndex >= 0 && as.get(aIndex) == bs.get(bIndex)) {
				--aIndex;
				--bIndex;
				found = true;
			}
			return found ? as.get(aIndex + 1) : null; 
		}
		return null;
	}
	
	public static void main(String[] args) {
		ListNode headA = new ListNode(1);
		ListNode headB = new ListNode(1);
		headA.next = new ListNode(2);
		headB.next = new ListNode(2);
		System.out.println(improve(headA, headB));
	}
	
}
