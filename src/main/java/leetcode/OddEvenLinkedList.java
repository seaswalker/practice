package leetcode;

/**
 * 栗子:
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * @author skywalker
 *
 */
public class OddEvenLinkedList {

	//1ms
	public static ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        boolean odd = true;
        ListNode pre = null, node = head, evensHead = null, evensCur = null, lastOdd = null;
        while (node != null) {
        	if (!odd) {
        		//如果是偶数位,使前后节点连起来
        		pre.next = node.next;
        		if (evensHead == null) {
        			evensHead = (evensCur = node);
        		} else {
        			evensCur.next = node;
        			evensCur = node;
        		}
        	} else {
        		lastOdd = node;
        	}
        	odd = !odd;
        	pre = node;
        	node = node.next;
        }
        lastOdd.next = evensHead;
        if (evensCur != null) evensCur.next = null;
        return head;
    }
	
	public static void main(String[] args) {
		ListNode list = ListNode.generateList(new int[] {1});
		oddEvenList(list).print();
	}
	
}
