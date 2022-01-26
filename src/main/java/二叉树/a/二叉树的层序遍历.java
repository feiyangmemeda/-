package 二叉树.a;

import java.util.ArrayList;
import java.util.List;

/**
 *  给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *  输入：root = [3,9,20,null,null,15,7]
 *  输出：[[3],[9,20],[15,7]]
 */
public class 二叉树的层序遍历 {

    public static void main(String[] args) {
        // 构造出例子
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        // 前序遍历
        rootPrint(root);
        // 层序遍历

    }

    static void rootPrint(TreeNode root){
        System.out.print(root.val);
        if(root.left != null ){
            rootPrint(root.left);
        }
        if(root.right != null ){
            rootPrint(root.right);
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        return null;
    }



}
