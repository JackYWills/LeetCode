package lintcode.BinaryTree;

import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author: JackYan
 * @Date2019/12/28 9:45
 * @Version V1.0
 **/
public class TestDrive {

    public static void main(String[] args) {
        TreeNode tn = CreateBinary.createBinaryTreeByArray(new Integer[]{1,2,3,4,null,5,6,7});
        PreOrderTraversal pt = new PreOrderTraversal();
        List<Integer> result = pt.preOrderTraversal(tn);
        Iterator<Integer> iterator = result.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
        }
    }
}
