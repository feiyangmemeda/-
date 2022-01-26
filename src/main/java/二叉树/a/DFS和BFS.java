package 二叉树.a;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 深度优先搜索和广度优先搜索
 */
public class DFS和BFS {
    public static void main(String[] args) {
        // 构造出例子
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        root.left = left;
        left.left = new TreeNode(11);
        left.right = new TreeNode(12);
        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        TreeNode a1 = root;
        dfs(a1);
        TreeNode a2 = root;
        bfs(a2);

    }

    static void dfs(TreeNode root) {
        System.out.println(root.val);
        if(root.left!=null) {
            dfs(root.left);
        }
        if(root.right != null ){
            dfs(root.right);
        }
    }

    static void bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }


}
