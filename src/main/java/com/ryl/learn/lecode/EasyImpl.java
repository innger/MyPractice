package com.ryl.learn.lecode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * EasyImpl 实现
 * Created on 16/7/7 下午3:28.
 */
public class EasyImpl {

    public static void main(String[] args) {
        EasyImpl easy = new EasyImpl();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
//        TreeNode node = root;
//        for (int i = 2; i <= 5; i++) {
//            TreeNode tmp = new TreeNode(i);
//            node.left = tmp;
//            node = tmp;
//        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        System.out.println(root.val + " " + root.right.val);
        easy.findPath(root, root.right, stack);
        while (!stack.empty()) {
            System.out.println(stack.pop().val);
        }
        System.out.println("===================");
        System.out.println(root.val + " " + root.left.right.val);
        easy.findPath(root, root.left.right, stack);
        while (!stack.empty()) {
            System.out.println(stack.pop().val);
        }

        easy.lowestCommonAncestor(root, root, root.right);

    }

    /**
     * 257. Binary Tree Paths
     * Given a binary tree, return all root-to-leaf paths.
     *
     * @param root TreeNode
     * @return List<String>
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // TODO: 16/7/8  
        return null;
    }

    /**
     * 225. Implement Stack using Queues
     * LinkedList 居然实现Deque extends Queue接口
     */
    class MyStack {

        private Queue<Integer> queue1 = new LinkedList<Integer>();
        private Queue<Integer> queue2 = new LinkedList<Integer>();

        // Push element x onto stack.
        public void push(int x) {
            while (!queue1.isEmpty()) {
                Integer i = queue1.poll();
                queue2.add(i);
            }
            queue1.add(x);
            while (!queue2.isEmpty()) {
                Integer i = queue2.poll();
                queue1.add(i);
            }
        }

        // Removes the element on top of the stack.
        public void pop() {
            queue1.poll();
        }

        // Get the top element.
        public int top() {
            return queue1.peek();
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return queue1.isEmpty();
        }
    }


    /**
     * 232. Implement Queue using Stacks
     * bug-free
     */
    class MyQueue {

        private Stack<Integer> inStack = new Stack<Integer>();
        private Stack<Integer> outStack = new Stack<Integer>();

        // Push element x to the back of queue.
        public void push(int x) {
            while (!inStack.isEmpty()) {
                Integer i = inStack.pop();
                outStack.push(i);
            }
            inStack.push(x);
            while (!outStack.isEmpty()) {
                Integer i = outStack.pop();
                inStack.push(i);
            }
        }

        // Removes the element from in front of queue.
        public void pop() {
            inStack.pop();
        }

        // Get the front element.
        public int peek() {
            return inStack.peek();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return inStack.isEmpty();
        }
    }


    /**
     * 235. Lowest Common Ancestor of a Binary Search Tree
     * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
     * <p>
     * 两个链表,找最后一个公共节点
     *
     * @param root TreeNode
     * @param p    TreeNode
     * @param q    TreeNode
     * @return TreeNode
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        findPath(root, p, stack1);
        findPath(root, q, stack2);
        TreeNode[] arr1 = new TreeNode[stack1.size()];
        int i = stack1.size() - 1;
        while (!stack1.empty()) {
            arr1[i] = stack1.pop();
            i--;
        }

        i = stack2.size() - 1;
        TreeNode[] arr2 = new TreeNode[stack2.size()];
        while (!stack2.empty()) {
            arr2[i] = stack2.pop();
            i--;
        }
        TreeNode commom = null;
        i = 0;
        while (i < arr1.length && i < arr2.length) {
            if (arr1[i] == arr2[i]) {
                commom = arr1[i];
            } else {
                break;
            }
            i++;
        }
        return commom;
    }

    private boolean findPath(TreeNode root, TreeNode p, Stack<TreeNode> stack) {
        // TODO: 16/7/8
        if (root == null)
            return false;
        if (root == p) {
            stack.push(p);
            return true;
        }
        boolean res = false;
        stack.push(root);
        if (root.left != null) {
            res = findPath(root.left, p, stack);
        }
        if (res) return true;

        stack.pop();
        if (root.right != null) {
            res = findPath(root.right, p, stack);
            if(!res)
                stack.push(root);
        }
        return res;
    }

    /**
     * 112. Path Sum
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
     * adding up all the values along the path equals the given sum.
     * <p>
     * 居然bug-free,这都行
     *
     * @param root TreeNode
     * @param sum  int
     * @return true/false
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
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
     * 二叉树递归解法,一般看上去都很对称美
     *
     * @param root TreeNode
     * @return int depth
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = 0;
        if (root.left != null) {
            left = 1 + minDepth(root.left);
        }
        int right = 0;
        if (root.right != null) {
            right = 1 + minDepth(root.right);
        }
        if (left == 0 || right == 0) {
            return Math.max(left, right);
        }
        return Math.min(left, right);
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
        //todo
        return null;
    }
}
