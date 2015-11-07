package leetcode;

/**
 * 排好序的数组转为平衡二叉树
 * @author skywalker
 *
 */
public class ConvertSortedArraytoBinarySearchTree {

	/**
	 * 1ms / O(n)
	 * 非原创，思路类似于二分查找，中点为根节点，中点左侧为左子树，右侧为右子树
	 * @see https://leetcode.com/discuss/10484/my-accepted-java-solution
	 */
	private static TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return helper(nums, 0, nums.length - 1);
	}
	
	private static TreeNode helper(int[] nums, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = low + ((high - low) >> 1);
		TreeNode node = new TreeNode(nums[mid]);
		node.left = helper(nums, low, mid - 1);
		node.right = helper(nums, mid + 1, high);
		return node;
	}
	
	public static void main(String[] args) {
		sortedArrayToBST(new int[] {1, 2, 3, 4, 5, 6}).print();
	}
	
}
