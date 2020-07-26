package lintcode.BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description:
 * @Author: JackYan
 * @Date2019/12/29 8:35
 * @Version V1.0
 **/
public class InOrderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     * @description:题解：按照左根右的次序遍历二叉树，搜索左子树，存入当前点，搜索右子树。
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curt = root;
        while (curt != null || !stack.empty()) {
            while (curt != null) {
                stack.add(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            result.add(curt.val);
            curt = curt.right;
        }
        return result;
    }

    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     * @descripion: 题解：首先访问左子树，将根节点的整个左子树存入栈中，
     * 每次将栈顶元素存入结果，如果右子树为空，取出栈顶元素，
     * 如果当前元素为栈顶元素右子树，一直弹出至当前元素不为栈顶元素右子树
     * (说明访问右子树，根节点已经被访问过，弹出即可)。
     * 如果节点右子树不为空，访问右子树，继续循环遍历左子树，存入栈中。
     */
    public ArrayList<Integer> inOrderTraversalDiff(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            result.add(node.val);
            if (node.right == null) {
                node = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            } else {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return result;
    }

}
