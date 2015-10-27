package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 逐层遍历二叉树，示例:
 *  3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * 结果:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 这个和@see leetcode.BinaryTreeLevelOrderTraversalII相似，那个是倒过来，这个还更简单
 * @author skywalker
 *
 */
public class BinaryTreeLevelOrderTraversal {

	private static List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        recursive(list, result);
        return result;
	}
	
	/**
	 * 递归二叉树
	 * 2ms
	 * @param root 树的根节点，必定不为空
	 * @param result 结果链表
	 */
	private static void recursive(List<TreeNode> nodes, List<List<Integer>> result) {
		List<Integer> level = new ArrayList<Integer>();
		List<TreeNode> next = new ArrayList<TreeNode>();
		TreeNode node;
		for (int i = 0, l = nodes.size();i < l;++i) {
			node = nodes.get(i);
			if (node.left != null) {
				next.add(node.left);
			}
			if (node.right != null) {
				next.add(node.right);
			}
			level.add(node.val);
		}
		result.add(level);
		if (next.size() > 0) {
			recursive(next, result);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(levelOrder(TreeNode.genarateTree(new int[] {3,9,20,TreeNode.NULL_NODE,TreeNode.NULL_NODE,15,7})));
	}
	
}
