package leetcode;

/**
 * 判断给定的二叉树是否是平衡二叉树
 * 关于平衡二叉树:
 * 1. 别名:Balanced Binary Tree, Height-Balanced Binary Tree, AVL Tree
 * 2. 前提首先是一棵二叉搜索/排序树
 * 3. 左子树和右子树必须也是AVL Tree
 * 4. 最关键的，左右子树的深度之差的绝对值不超过1
 * -- 参见《数据结构》 2333页
 * @author skywalker
 *
 */
public class BalancedBinaryTree {
	
	public static void main(String[] args) {
		System.out.println(isBalanced(null));
	}
	
	/**
	 * 此题不要求判断是否是排序二叉树
	 */
	private static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	/**
	 * 求树的深度
	 * @param tree
	 * @return
	 */
	private static int getDepth(TreeNode tree) {
		if (tree == null) {
			return 0;
		}
		return Math.max(getDepth(tree.left), getDepth(tree.right)) + 1;
	}
	
}
