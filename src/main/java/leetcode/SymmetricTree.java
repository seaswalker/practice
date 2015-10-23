package leetcode;

/**
 * 判断一棵二叉树是否是对称二叉树
 * @author skywalker
 *
 */
public class SymmetricTree {
	
	/**
	 * 更好的算法 1ms
	 * @see https://leetcode.com/discuss/63463/java-self-explanatory-1ms-recursive-solution
	 */
	@SuppressWarnings("unused")
	private static boolean improve(TreeNode root) {
		if (root == null)
			return true;
		return isSymSubTree(root.left, root.right);
	}
	
	private static boolean isSymSubTree(TreeNode left, TreeNode right) {
		if (left == null)
			return (right == null);
		if (right == null)
			return false;
		return (left.val == right.val) && isSymSubTree(left.left, right.right)
				&& isSymSubTree(left.right, right.left);
	}

	/**
	 * Accept 29ms
	 */
	private static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		//存放每一层的节点
		TreeNode[] o = new TreeNode[2];
		o[0] = root.left;
		o[1] = root.right;
		TreeNode[] n;
		int nl, length;
		//是否全部是空值
		boolean isAllNull = true;
		//逐层扫描
		while (true) {
			length = o.length;
			for (int i = 0, l = length / 2;i < l;++i) {
				if (o[i] == null) {
					if (o[length - 1 - i] != null) {
						isAllNull = !hasChild(o[length - 1 - i]);
						return false;
					}
				} else if (o[length - i - 1] == null) {
					isAllNull = !hasChild(o[length - 1 - i]);
					return false;
				} else {
					isAllNull = !(hasChild(o[i]) || hasChild(o[length - 1 - i]));
					if (o[i].val != o[length - i - 1].val) {
						return false;
					}
				}
			}
			if (isAllNull) {
				return true;
			}
			nl = length << 1;
			n = new TreeNode[nl];
			//设置下一层节点
			for (int i = 0;i < length;i ++) {
				if (o[i] != null) {
					n[i << 1] = o[i].left;
					n[(i << 1) + 1] = o[i].right;
				}
			}
			o = n;
			n = null;
		}
	}
	
	/**
	 * 判断一个节点是否有子节点
	 */
	private static boolean hasChild(TreeNode node) {
		return node != null && (node.left != null || node.right != null);
	}
	
	//准备一棵测试用二叉树
	private static TreeNode prepare() {
		TreeNode root = new TreeNode(2);
		TreeNode ptr = root;
		ptr.left = new TreeNode(3);
		ptr = ptr.left;
		ptr.left = new TreeNode(4);
		ptr.right = new TreeNode(5);
		ptr = ptr.right;
		ptr.left = new TreeNode(8);
		ptr.right = new TreeNode(9);
		root.right = new TreeNode(3);
		ptr = root.right;
		ptr.left = new TreeNode(5);
		ptr.right = new TreeNode(4);
		ptr = ptr.right;
		ptr.left = new TreeNode(9);
		ptr.right = new TreeNode(8);
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode tree = prepare();
		System.out.println(isSymmetric(tree));
	}
	
}
