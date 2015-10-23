package leetcode;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
	}	
	
	@Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
	
	/**
     * 打印二叉树(先序遍历)
     * @param root 根节点
     */
	public static void printTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printTree(root.left);
            printTree(root.right);
        }
    }
	
}
