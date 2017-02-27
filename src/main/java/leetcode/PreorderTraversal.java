package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 使用循环实现先序遍历(中序遍历也实现在这里了)
 * 难度: 中等
 * Created by skywalker on 2015/10/20.
 */
public class PreorderTraversal {

    public static void main(String[] args) {
        TreeNode tree = prepare();
        System.out.println(preorderTraversal(tree));
        System.out.println(inorderTraversal(tree));
    }

    /**
     * 准备一颗二叉树
     */
    private static TreeNode prepare() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        //2
        TreeNode ptr = root.left;
        ptr.left = new TreeNode(4);
        ptr.right = new TreeNode(5);
        ptr = ptr.right;
        ptr.left = new TreeNode(6);
        ptr.right = new TreeNode(7);
        return root;
    }

    /**
     * 先序遍历
     * @param root
     * @return
     */
    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        //向左走到尽头
        while (node != null) {
            list.add(node.val);
            stack.push(node);
            node = node.left;
        }
        //遍历栈
        while (!stack.isEmpty()) {
            node = stack.pop().right;
            //如果右子树下还有左子树，那么同样走到尽头
            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
        }
        return list;
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        //向左走到尽头
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        //遍历栈
        while (!stack.isEmpty()) {
            node = stack.pop();
            list.add(node.val);
            node = node.right;
            //如果右子树下还有左子树，那么同样走到尽头
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return list;
    }

}
