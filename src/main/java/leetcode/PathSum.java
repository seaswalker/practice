package leetcode;

import static leetcode.TreeNode.*;

/**
 * 判断给定的二叉树是否含有一条从root到leaf且各节点的值相加等于给定的值的路径
 * 测试数据:
 * {1, 2}, 2 -> 1 false
 * {1}, 1 -> true
 * {1, 2, NULL_NODE, 3, NULL_NODE, 4, NULL_NODE, 5}, 6 -> false
 * {1, -2, -3, 1, 3, -2, NULL_NODE, -1}, 2 -> true
 * {}, 0 -> false
 * {2, NULL_NODE, -3}, -2 -> false
 * @author skywalker
 *
 */
public class PathSum {

	//1ms
	private static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		} 
		return recursive(root, sum);
	}
	
	private static boolean recursive(TreeNode root, int sum) {
		//如果没有子节点
		if (root.left == null && root.right == null) {
			return root.val == sum;
		}
		//搜索左子树
		if (root.left != null) {
			if (recursive(root.left, sum - root.val)) {
				return true;
			}
		}
		if (root.right != null) {
			if (recursive(root.right, sum - root.val)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(hasPathSum(TreeNode.genarateTree(new int[] {-2, NULL_NODE, -3}), -2));
	}
	
}
