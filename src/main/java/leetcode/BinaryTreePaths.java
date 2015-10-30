package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 找到二叉树的所有从root到叶子节点路径
 * @author skywalker
 *
 */
public class BinaryTreePaths {

	//3ms
	private static List<String> binaryTreePaths(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		List<String> result = new ArrayList<String>();
		recursive(root, String.valueOf(root.val), result);
		return result;
	}
	
	/**
	 * 递归寻找路径
	 * @param up 父节点
	 * @param path 上一级的路径串
	 * @param result 结果链表
	 */
	private static void recursive(TreeNode up, String path, List<String> result) {
		if (up.left == null && up.right == null) {
			result.add(path);
		} else {
			if (up.left != null) {
				recursive(up.left, path + "->" + up.left.val, result);
			}
			if (up.right != null) {
				recursive(up.right, path + "->" + up.right.val, result);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(binaryTreePaths(TreeNode.genarateTree(new int[] {1, 2, 3, TreeNode.NULL_NODE, 5})));
		
	}
	
}
