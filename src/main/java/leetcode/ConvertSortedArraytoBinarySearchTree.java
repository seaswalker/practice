package leetcode;

/**
 * 排好序的数组转为平衡二叉树
 * @author skywalker
 *
 */
public class ConvertSortedArraytoBinarySearchTree {

	private static TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(nums[0]);
		int n;
		for (int i = 1, l = nums.length;i < l; ++i) {
			n = nums[i];
			if (insertNode(root, n)) {
				root = rightBalance(root);
			}
		}
		return root;
	}
	
	/**
	 * 向平衡二叉树插入一个新的节点
	 * 由于给定数组是排好序(升序)的，所以插入的位置必定在右子树的尽头
	 * @param root 根节点，非空
	 * @param val
	 * @return 是否插入了节点
	 */
	private static boolean insertNode(TreeNode root, int val) {
		TreeNode node = root;
		while (node.val < val && node.right != null) {
			node = node.right;
		}
		if (node.val < val) {
			node.right = new TreeNode(val);
			return true;
		}
		return false;
	}
	
	/**
	 * 检查并修复右子树的不平衡
	 * @param root 根节点
	 * @return 返回新的根节点
	 */
	private static TreeNode rightBalance(TreeNode root) {
		TreeNode next = root, pre = null, current = null, node;
		boolean flag = false;
		//找到最深的不平衡节点
		//TODO 是否无需考虑左子树?
		while (blanceFactor(next) < -1) {
			pre = current;
			current = next;
			next = next.right;
			flag = true;
		}
		if (flag) {
			//左旋
			///TODO bug
			//向左到尽头，因为current子树必定比next要小
			node = next;
			while (node.left != null) {
				node = node.left;
			}
			node.left = current;
			current.right = null;
			if (pre == null) {
				//是根节点
				root = next;
			} else {
				pre.right = next;
			}
			//leftBalance(node, next);
		}
		return root;
	}
	
	/**
	 * 检测并修复左子树的不平衡
	 * @param root 根节点，非空
	 */
	@SuppressWarnings("unused")
	private static void leftBalance(TreeNode root) {
		TreeNode pre = null, current = null, next = root;
		boolean flag = false;
		while (blanceFactor(next) > 1) {
			pre = current;
			current = next;
			next = next.left;
			flag = true;
		}
		if (flag) {
			if (pre != null) {
				pre.left = next;
				next.right = current;
				current.left = null;
			}
		}
	}
	
	/**
	 * 获取node节点的平衡因子(左子树深度减右子树深度)
	 * @param node 非空
	 * @return
	 */
	private static int blanceFactor(TreeNode node) {
		return getDepth(node.left) - getDepth(node.right);
	}
	
	/**
	 * 获取最大树深
	 * @param node 根节点
	 * @return
	 */
	private static int getDepth(TreeNode root) {
		if (root == null) {
			return 1;
		}
		return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
	}
	
	public static void main(String[] args) {
		sortedArrayToBST(new int[] {1, 2, 3, 4, 5, 6}).print();
	}
	
}
