package com.ryl.learn.lecode;

import java.util.List;

/**
 * EasyImpl 实现
 * Created on 16/7/7 下午3:28.
 */
public class EasyImpl {

    public static void main(String[] args) {
        EasyImpl easy = new EasyImpl();

        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
        TreeNode node = root;
        for(int i = 2 ; i<= 5 ;i++) {
            TreeNode tmp = new TreeNode(i);
            node.left = tmp;
            node = tmp;
        }

        System.out.println(easy.minDepth(root));
    }

    /**
     * 112. Path Sum
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
     * adding up all the values along the path equals the given sum.
     *
     * 居然bug-free,这都行
     *
     * @param root TreeNode
     * @param sum int
     * @return true/false
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null ) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 111. Minimum Depth of Binary Tree
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     * Depth-first Search
     * Breadth-first Search
     * 叶子节点到根节点的最短高度
     *
     * @param root TreeNode
     * @return int depth
     */
    public int minDepth(TreeNode root) {
        //// TODO: 16/7/7
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = 1 + minDepth(root.left);
        System.out.println(left);
        int right = 1 + minDepth(root.right);
        return Math.min(left, right);
    }

    private int findLeaf(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return 1;
        }
        return 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 根据输入的List构造二叉树
     * [1,2,3,4,5]
     * [1,2,null,3,null,4,null,5,null]
     *
     * @param list List<Integer>
     * @return
     */
    public TreeNode constructTree(List<Integer> list) {
        return null;
    }
}
