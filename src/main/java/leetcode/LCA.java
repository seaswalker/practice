package leetcode;

/**
 * 在二叉搜索树需找LCA，首先说明:
 * 二叉搜索树(Binary Search Tree)就是二叉排序树(Binary Sort Tree)，具有如下的性质:
 * 1. 可以是一颗空树
 * 2. 若左子树不空，那么左子树所有节点的值均小于其根节点的值
 * 3. 若右子树不空，那么右子树所有节点的值均大于其根节点的值
 * 4. 其左、右子树也是BST
 * 5. 另外根据BST的定义，BST里面是不可能存在相等的元素的，所以一开始你完全理解错了题意
 * 参见<>数据结构</>227页
 * 维基百科连接:
 * @see "https://en.wikipedia.org/wiki/Lowest_common_ancestor"
 * 测试数据:
 * 二叉树
 *        _______6______
 *       /              \
 *    ___2__          ___8__
 *   /      \        /      \
 *   0       4       7       9
 *         /   \
 *        3     5
 *
 *  (2, 8) -> 6
 *  (2, 4) -> 4
 *  (3, 9) -> 6
 *  (3, 5) -> 4
 *  (5, 3) -> 4
 * Created by skywalker on 2015/10/19.
 */
@SuppressWarnings("unused")
public class LCA {

    public static void main(String[] args) {
        TreeNode tree = prepare();
        //TreeNode.printTree(tree);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        System.out.println(lowestCommonAncestor(tree, p, q));
    }

    /**
     * 准备测试二叉树
     * @return
     */
    private static TreeNode prepare() {
        TreeNode root = new TreeNode(6);
        //辅助指针
        TreeNode ptr;
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode right = new TreeNode(8);
        root.right = right;
        ptr = left;
        left = new TreeNode(0);
        ptr.left = left;
        right = new TreeNode(4);
        ptr.right = right;
        //4
        ptr = right;
        //4的左子树3
        left = new TreeNode(3);
        ptr.left = left;
        //4的右子树5
        right = new TreeNode(5);
        ptr.right = right;
        //8
        ptr = root.right;
        ptr.left = new TreeNode(7);
        ptr.right = new TreeNode(9);
        return root;
    }

    /**
     * @param root
     * @param p
     * @param q
     * @return
     */
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //需要搜索的两个节点不能为空
        if (root != null && p != null && q != null) {
            //p和q的大小是未知的
            TreeNode bigger, smaller;
            if (p.val > q.val) {
                bigger = p;
                smaller = q;
            } else {
                bigger = q;
                smaller = p;
            }
            if (smaller.val == root.val) {
                return exists(root.right, bigger.val) ? root : null;
            } else if (bigger.val == root.val) {
                return exists(root.left, smaller.val) ? root : null;
            } else if (smaller.val > root.val) {
                return lowestCommonAncestor(root.right, smaller, bigger);
            } else if (bigger.val < root.val) {
                return lowestCommonAncestor(root.left, smaller, bigger);
            } else {
                return exists(root.left, smaller.val) && exists(root.right, bigger.val) ? root : null;
            }
        }
        return null;
    }

    /**
     * 另一种简洁的写法，之所以不是better，是因为我的算法10ms，这个11ms
     * 其实可以看出此算法是假定要搜索的节点是一定存在的，而我的算法无此假设
     * @param root
     * @param p
     * @param q
     * @return
     */
    private static TreeNode another(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (p.val > root.val && q.val > root.val) {
            root = lowestCommonAncestor(root.right, p, q);
        }
        else if (p.val < root.val && q.val < root.val) {
            root = lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    /**
     * val是否存在于root子树中
     * @param root
     * @param val
     * @return 存在返回true
     */
    private static boolean exists(TreeNode root, int val) {
        if (root != null) {
            if (root.val == val) {
                return true;
            } else if (val < root.val) {
                //搜索左子树
                return exists(root.left, val);
            } else {
                //搜索右子树
                return exists(root.right, val);
            }
        }
        return false;
    }

}
