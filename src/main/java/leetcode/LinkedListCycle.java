package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个链表是否有环
 * Created by skywalker on 2015/10/20.
 */
@SuppressWarnings("unused")
public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode list = prepare();
        System.out.println(hasCycleWithoutExtraspace(list));
    }

    /**
     * 链表结构3 -> 2 -> 0 -> -4
     *             ^----------|
     * @return
     */
    private static ListNode prepare() {
        ListNode head = new ListNode(3);
        ListNode node = new ListNode(2);
        ListNode tar = node;
        head.next = node;
        node.next = new ListNode(0);
        node = node.next;
        node.next = new ListNode(-4);
        node = node.next;
        node.next = tar;
        return head;
    }

    /**
     * 7ms
     */
    private static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 不使用额外空间的版本
     * 这个思路的脑洞实在是有点大，需要两个指针，一个每次走2步，另一个每次走1步，
     * 如果有环存在，那么走2步的会追上走1步的,只能是每次多1步，不然应该会出现超过的情况
     * 1ms
     * @see "https://leetcode.com/discuss/32906/o-1-space-solution"
     */
    private static boolean hasCycleWithoutExtraspace(ListNode head) {
        if (head != null) {
            ListNode slower = head;
            ListNode faster = head;
            while (faster.next != null && faster.next.next != null) {
                slower = slower.next;
                faster = faster.next.next;
                //追上
                if (slower == faster) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
