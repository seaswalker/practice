package leetcode;

/**
 * 判断给定的二叉树是否含有一条从root到leaf且各节点的值相加等于给定的值的路径
 * @author skywalker
 *
 */
public class PathSum {

	private static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		} else if (root.left == null && root.right == null) {
			return root.val == sum;
		} else if (root.left != null) {
			if (recursive(root.left, sum - root.val)) {
				return true;
			}
		} else if (recursive(root.right, sum - root.val)) {
			return true;
		}
		return false;
	}
	
	private static boolean recursive(TreeNode root, int sum) {
		if (root == null) {
			return sum == 0;
		}
		if (root.left == null && root.right == null) {
			return root.val == sum;
		} 
		if (root.left != null) {
			if (recursive(root.left, sum - root.val)) {
				return true;
			}
		} 
		if (recursive(root.right, sum - root.val)) {
			return true;
		}
		return false;
	}
	
	private static TreeNode prepare() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		return root;
	}
	
	public static void main(String[] args) {
		System.out.println(hasPathSum(prepare(), 2));
	}
	
}
