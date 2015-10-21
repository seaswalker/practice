package leetcode;

/**
 * 求二叉树的最大深度
 * Created by skywalker on 2015/10/18.
 */
@SuppressWarnings("unused")
public class MaxDepthBT {

    public static void main(String[] args) {
        maxDepth(null);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

}
