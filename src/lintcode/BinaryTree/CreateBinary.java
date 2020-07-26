package lintcode.BinaryTree;

/**
 * @Description:
 * @Author: JackYan
 * @Date2019/12/28 21:01
 * @Version V1.0
 **/
public class CreateBinary {

    static TreeNode createBinaryTreeByArray(Integer[] nums){
        CreateBinary td = new CreateBinary();
        return td.createBinaryTreeByArrayRecursion(nums,0);
    }

    // 根据数组创建二叉树，并返回头结点
    private TreeNode createBinaryTreeByArrayRecursion(Integer[] nums,int index) {
        TreeNode tn = null;
        if (index<nums.length) {
            Integer value = nums[index];
            if (value == null) {
                return null;
            }
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArrayRecursion(nums, 2*index+1);
            tn.right = createBinaryTreeByArrayRecursion(nums, 2*index+2);
            return tn;
        }
        return tn;
    }

}
