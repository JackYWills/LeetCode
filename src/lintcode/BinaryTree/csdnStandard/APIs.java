package lintcode.BinaryTree.csdnStandard;

import java.util.Scanner;

/**
 * @Description:
 * @Author: JackYan
 * @Date2019/12/28 20:28
 * @Version V1.0
 **/
class APIs {
    static final int MAXLEN = 20;
    static Scanner input = new Scanner(System.in);

    //初始化二叉树的根
    BinaryTreeNode initTree() {
        BinaryTreeNode node = null;
        if ((node = new BinaryTreeNode()) != null) {
            System.out.printf("请先输入一个根结点数据: \n");
            node.data = input.next();
            node.left = null;
            node.right = null;
//          return node;
        }
        return node;
    }

    //添加结点
    void addTreeNode(BinaryTreeNode treeNode) {
        BinaryTreeNode pnode, parent;
        String data;
        int menuse1;

        if ((pnode = new BinaryTreeNode()) != null) {
            System.out.printf("输入二叉树结点数据:\n");
            pnode.data = input.next();
            pnode.left = null;
            pnode.right = null;

            System.out.println("输入该结点的父节点数据：");
            data = input.next();

            parent = TreeFindNode(treeNode, data);
            if (parent == null) {
                System.out.println("未找到该父节点!\n");
                pnode = null;//释放创建的结点内容
                return;
            }
            System.out.println("1.添加该结点到左子树");
            System.out.println("2.添加该结点到右子树");
            do {
                menuse1 = input.nextInt();
                if (menuse1 == 1 || menuse1 == 2) {
                    if (parent == null) {
                        System.out.println("不存在父节点，请先设置父节点!");
                    } else {
                        switch (menuse1) {
                            case 1:
                                if (parent.left != null) {
                                    System.out.println("左子树 结点不为空!");
                                } else {
                                    parent.left = pnode;
                                }
                                break;
                            case 2:
                                if (parent.right != null) {
                                    System.out.println("右子树结点不为空!");
                                } else {
                                    parent.right = pnode;
                                }
                                break;
                            default:
                                System.out.println("无效参数!");
                        }

                    }
                }
            } while (menuse1 != 1 & menuse1 != 2);
        }
    }

    private BinaryTreeNode TreeFindNode(BinaryTreeNode treeNode, String data) {
        BinaryTreeNode ptr;
        if (treeNode == null) {
            return null;
        } else {
            if (treeNode.data.equals(data)) {
                return treeNode;
            } else {
                if ((ptr = TreeFindNode(treeNode.left, data)) != null) {
                    return ptr;
                } else if ((ptr = TreeFindNode(treeNode.right, data)) != null) {
                    return ptr;
                } else return null;
            }
        }
    }

    BinaryTreeNode TreeLeftNode(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            return treeNode.left;
        } else return null;
    }

    BinaryTreeNode TreeRightNode(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            return treeNode.right;
        } else return null;
    }

    //判断是否为空
    boolean TreeIsEmpty(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            return false;
        } else {
            return true;
        }
    }

    //计算二叉树的的深度
    int TreeDepth(BinaryTreeNode treeNode) {
        int depleft, depright;
        if (treeNode == null) {
            return 0;
        } else {
            depleft = TreeDepth(treeNode.left);
            depright = TreeDepth(treeNode.right);
            if (depleft > depright) {
                return depleft + 1;
            } else {
                return depright + 1;
            }
        }
    }

    //清空二叉树
    void ClearTree(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            ClearTree(treeNode.left);
            ClearTree(treeNode.right);
            treeNode = null;
        }
    }

    //显示结点数据
    void TreeNodeData(BinaryTreeNode p) {
        System.out.printf("%s", p.data);
    }

    //层序遍历
    void LevelTraversalTree(BinaryTreeNode treeNode) {
        BinaryTreeNode p;
        BinaryTreeNode[] q = new BinaryTreeNode[MAXLEN];
        int head = 0, tail = 0;
        if (treeNode != null) {
            tail = (tail + 1) % MAXLEN;
            q[tail] = treeNode;
        }
        while (head != tail) {
            head = (head + 1) % MAXLEN;
            p = q[head];
            TreeNodeData(p);
            if (p.left != null) {
                tail = (tail + 1) % MAXLEN;
                q[tail] = p.left;
            }
            if (p.right != null) {
                tail = (tail + 1) % MAXLEN;
                q[tail] = p.right;
            }
        }
    }

    //后序遍历
    void PostTraversalTree(BinaryTreeNode root) {
        if (root != null) {
            PostTraversalTree(root.left);
            PostTraversalTree(root.right);
            TreeNodeData(root);
        }
    }

    //前序遍历
    void PreTraversalTree(BinaryTreeNode root) {
        if (root != null) {
            TreeNodeData(root);
            PreTraversalTree(root.left);
            PreTraversalTree(root.right);
        }
    }

    //中序遍历
    void InTraversalTree(BinaryTreeNode root) {
        if (root != null) {
            InTraversalTree(root.left);
            TreeNodeData(root);
            InTraversalTree(root.right);
        }
    }
}
