package lintcode.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:二叉树的前序遍历
 * 非递归方式实现前序遍历时，首先存入当前节点值，
 * 然后先将右儿子压入栈中，再将左儿子压入栈中。对栈中元素遍历访问。
 * @Author: JackYan
 * @Date2019/12/27 20:26
 * @Version V1.1
 **/
public class PreOrderTraversal {
     /** 1、遍历 **/
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return preOrder;
        }
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            preOrder.add(node.val);
            // 栈先进后出
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return preOrder;
    }

    /** 2、递归 **/
    public ArrayList<Integer> preOrderTraversalRecursion(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    // 把root为跟的preOrder加入result里面
    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }

    /** 3、分治法: Divide & Conquer **/
    public ArrayList<Integer> preOrderTraversalDivideConquer(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // null or leaf
        if (root == null) {
            return result;
        }
        // Divide
        ArrayList<Integer> left = preOrderTraversalDivideConquer(root.left);
        ArrayList<Integer> right = preOrderTraversalDivideConquer(root.right);
        // Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}