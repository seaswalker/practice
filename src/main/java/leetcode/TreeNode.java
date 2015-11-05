package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {
	
	//如果数组的值是-77，那么代表空节点
	public static final int NULL_NODE = -77;

	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
	}	
	
	@Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
	
	/**
     * 打印二叉树(先序遍历)
     * @param root 根节点
     */
	public void print() {
		printHelper(this);
    }
	
	private void printHelper(TreeNode root) {
		TreeNode node = root;
		if (node != null) {
			System.out.print(node.val + " ");
			printHelper(root.left);
			printHelper(root.right);
		}
	}
	
	/**
	 * 根据给定的节点数组生成一棵树
	 * @param nodes 节点数组
	 * @return 
	 */
	public static TreeNode genarateTree(int[] nodes) {
		int l;
		if (nodes != null && (l = nodes.length) > 0) {
			TreeNode root = new TreeNode(nodes[0]);
			if (l > 1) {
				//保存上一层的节点
				Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
				queue.offer(root);
				//nodes数组下标
				int index = 1, n;
				TreeNode node;
				while (!queue.isEmpty()) {
					node = queue.poll();
					n = nodes[index++];
					if (n != NULL_NODE) {
						queue.offer(node.left = new TreeNode(n));
					}
					if (index == l) {
						return root;
					}
					n = nodes[index++];
					if (n != NULL_NODE) {
						queue.offer(node.right = new TreeNode(n));
					}
					if (index == l) {
						return root;                                                                                              
					}
				}
			}
			return root;
		}
		return null;
	}
	
}
