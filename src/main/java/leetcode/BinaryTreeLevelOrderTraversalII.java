package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 举个栗子:
 * 二叉树:
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * 返回(倒序):
 * [
 * 	[15,7],
 * 	[9,20],
 * 	[3]
 * ] 
 * @author skywalker
 *
 */
public class BinaryTreeLevelOrderTraversalII {

	private static List<List<Integer>> levelOrderBottom(TreeNode root) {
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
		//先加入下一层
		if (next.size() > 0) {
			recursive(next, result);
		}
		result.add(level);
	}
	
	private static TreeNode prepare() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		return root;
	}

	public static void main(String[] args) {
		System.out.println(levelOrderBottom(prepare()));
	}
	
}
