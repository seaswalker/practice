package leetcode;

import java.util.*;

/**
 * 令每个节点的next指针都指向右侧的节点，示例图:
 * 原树:
 *     1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 * 处理后的结果:
 *     1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 * 另外的要求:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * Created by skywalker on 2015/10/21.
 */
public class PopulateNextRight {

    public static void main(String[] args) {
        TreeLinkNode tree = prapre();
        connect(tree);
        TreeLinkNode.travel(tree);
    }

    /**
     * 准备一棵完全二叉树
     */
    private static TreeLinkNode prapre() {
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode ptr = new TreeLinkNode(2);
        root.left = ptr;
        ptr.left = new TreeLinkNode(4);
        ptr.right = new TreeLinkNode(5);
        ptr = new TreeLinkNode(3);
        root.right = ptr;
        ptr.left = new TreeLinkNode(6);
        ptr.right = new TreeLinkNode(7);
        return root;
    }

    /**
     * 处理二叉树,此题的思路:
     * 使用一个list保存每层的节点(从左往右)，而后遍历list，设置next关系，同时把节点保存到队列，
     * 再从队列取出把每个节点的子节点加入list
     */
    private static void connect(TreeLinkNode root) {
        if (root != null) {
            List<TreeLinkNode> list = new ArrayList<>();
            Queue<TreeLinkNode> queue = new ArrayDeque<>();
            TreeLinkNode node;
            list.add(root);
            int size;
            while ((size = list.size()) > 0) {
                for (int i = 0;i < size;++i) {
                    node = list.get(i);
                    if (i < size - 1) {
                        node.next = list.get(i + 1);
                    }
                    queue.offer(node);
                }
                //子节点再次加入list
                list.clear();
                while (!queue.isEmpty()) {
                    node = queue.poll();
                    if (node.left != null) {
                        list.add(node.left);
                        list.add(node.right);
                    }
                }
            }
        }
    }

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }

        @Override
        public String toString() {
            return "{" +
                    "val=" + val +
                    ", next=" + (next == null ? "null" : next.val) +
                    '}';
        }

        /**
         * 先序遍历
         */
        public static void travel(TreeLinkNode tree) {
            if (tree != null) {
                System.out.print(tree + " ");
                travel(tree.left);
                travel(tree.right);
            }
        }

    }

}
