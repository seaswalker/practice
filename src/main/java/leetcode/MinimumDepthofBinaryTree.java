package leetcode;

/**
 * 求二叉树的最小深度
 * @author skywalker
 *
 */
public class MinimumDepthofBinaryTree {

	//1ms
	private static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left != null) {
			if (root.right == null) {
				return minDepth(root.left) + 1;
			} else {
				return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
			}
		}
		if (root.right != null) {
			return minDepth(root.right) + 1;
		}
		return 1;
	}
	
	public static void main(String[] args) {
		System.out.println(minDepth(TreeNode.genarateTree(new int[] {1, 2, 3, 4})));
	}
	
}
