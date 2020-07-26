package lintcode.BinaryTree.csdnStandard;

import java.util.Scanner;

/**
 * @Description:
 * https://blog.csdn.net/qq_34649947/article/details/72994819
 * @Author: JackYan
 * @Date2019/12/28 20:28
 * @Version V1.0
 **/
class TestDrive {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        BinaryTreeNode root = null;
        int menuse1;
        APIs t = new APIs();
        //设置根元素
        root = t.initTree();
        //添加结点
        do {
            System.out.println("请选择菜单添加二叉树的结点\n");
            System.out.println("0.退出\t");//显示菜单
            System.out.println("1.添加二叉树的结点\n");
            menuse1 = input.nextInt();
            switch (menuse1) {
                case 1:
                    t.addTreeNode(root);
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (menuse1 != 0);

        //遍历
        do {
            System.out.println("请选择遍历二叉树，输入0表示退出: ");
            System.out.println("1.先序遍历");
            System.out.println("2.中序遍历");
            System.out.println("3.后序遍历");
            System.out.println("4.按层遍历");
            menuse1 = input.nextInt();
            switch (menuse1) {
                case 0:
                    break;
                case 1: //
                    System.out.println("先序遍历PreTraversalTree的结果是: ");
                    t.PreTraversalTree(root);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("中序遍历的结果是；");
                    t.InTraversalTree(root);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("后序遍历的结果是: ");
                    t.PostTraversalTree(root);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("按层遍历的结果是: ");
                    t.LevelTraversalTree(root);
                    System.out.println();
                    break;
                default:
                    break;
            }
        } while (menuse1 != 0);
        //深度
        System.out.println("二叉树深度为： %d" + t.TreeDepth(root));
        //清空二叉树
        t.ClearTree(root);
        root = null;
    }
}
