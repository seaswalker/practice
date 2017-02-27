package leetcode;

/**
 * 对于给定的n，有多少种结构不同的二叉搜索树(1-n)
 * @author skywalker
 *
 */
public class UniqueBinarySearchTrees {

	/**
	 * 这道题的思路是这样的(以n = 3为例):
	 * 1，2, 3都可以作为根节点，种数就是左子树的种数乘以右子树的种数，比如，2作为根节点，左子树只可以取1，所以只有一种，右子树只可以
	 * 取3，也是一种
	 * 此算法比递归要好，递归包含大量的重复计算
	 */
	private static int numTrees(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int[] nums = new int[n + 1];
		nums[0] = nums[1] = 1;
		nums[2] = 2;
		for (int i = 3;i <= n; ++i) {
			int temp = 0;
			for (int j = 0;j < i; ++j) {
				temp += nums[j] * nums[i - 1 - j];
			}
			nums[i] = temp;
		}
		return nums[n];
	}
	
	public static void main(String[] args) {
		System.out.println(numTrees(5));
	}
	
}
