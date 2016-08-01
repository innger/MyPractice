package com.ryl.learn.lecode;

import java.util.*;

/**
 * EasyImpl 实现
 * Created on 16/7/7 下午3:28.
 */
public class EasyImpl {

    public static void main(String[] args) {
        EasyImpl easy = new EasyImpl();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(easy.isSymmetric(root));
        System.out.println(easy.guessNumber(1792997410));

        //[1,2,3,4,5]
        //[1,2,null,3,null,4,null,5,null]
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(null);
        list.add(3);
        list.add(null);
        list.add(4);
        list.add(null);
        list.add(5);
        list.add(null);
        TreeNode head = easy.constructTree(list);
        System.out.println(easy.levelOrder(head));
        System.out.println(easy.generatePossibleNextMoves("++++-"));
    }

    /**
     * 293. Flip Game
     * take turns to flip two consecutive "++" into "--".
     * s = "++++"
     * output : "--++", "+--+", "++--"
     * 判断连续的是不是"++",将其反转后加入结果中去.
     *
     * @param s string
     * @return List string
     */
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() < 2) return result;
        for (int i = 0; i < s.length() - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            if (c1 == '+' && c2 == '+') {
                result.add(s.substring(0, i) + "--" + s.substring(i + 2));
            }
        }
        return result;
    }

    /**
     * 374. Guess Number Higher or Lower
     * pick a number from 1 to n. You have to guess which number I picked.
     * 数字猜大小 二分查找
     *
     * @param n int
     * @return int
     */
    public int guessNumber(int n) {
        int i = 1;
        int j = n;
        while (i < j) {
            int g = (j - i) / 2 + i; //(high - low) / 2 + low; // 直接使用(high + low) / 2 可能导致溢出
            int res = guess(g);
            if (res == 0) {
                return g;
            } else if (res == -1) {
                //my number is lower 猜大了
                j = g - 1;
            } else if (res == 1) {
                //my number is higher 猜小了
                i = g + 1;
            }
        }
        return i;
    }

    /* The guess API is defined in the parent class GuessGame.
        @param num, your guess
        @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num);
      1792997410
      1240808008
     */
    private int guess(int num) {
        int mynumber = 1240808008;
        if (mynumber == num) {
            return 0;
        } else if (mynumber > num) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * 101. Symmetric Tree
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     * 判断二叉树是否对称
     * recursively and iteratively
     *
     * @param root TreeNode
     * @return true/false
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        // left.left right.right 和 right.left,left.right
        return left != null && right != null && left.val == right.val && isSymmetric(left.left, right.right) &&
                isSymmetric(right.left, left.right);
    }

    /**
     * 遍历方式,队列实现
     * 分层打印类似
     *
     * @param root TreeNode
     * @return true/false
     */
    public boolean isSymmetricIterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node1 = q.poll();
            TreeNode node2 = q.poll();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;
            q.add(node1.left);
            q.add(node2.right);
            q.add(node1.right);
            q.add(node2.left);
        }
        return true;
    }

    /**
     * 102. Binary Tree Level Order Traversal
     * from left to right, level by level
     * 从上到下按层打印二叉树节点值
     * 剑指offer deque
     *
     * @param root TreeNode
     * @return List the level order traversal of its nodes' values
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (true) {
            List<Integer> list = new ArrayList<Integer>();
            Queue<TreeNode> tmpQ = new LinkedList<TreeNode>();
            levelQueue(queue, tmpQ, list);
            if (list.size() > 0) {
                result.add(list);
            }
            if (tmpQ.isEmpty())
                break;
            queue = tmpQ;
        }
        return result;
    }

    private void levelQueue(Queue<TreeNode> queue, Queue<TreeNode> tmpQ, List<Integer> list) {
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            list.add(node.val);
            if (node.left != null) {
                tmpQ.add(node.left);
            }
            if (node.right != null) {
                tmpQ.add(node.right);
            }
        }
    }

    /**
     * 107. Binary Tree Level Order Traversal II
     * from left to right, level by level from leaf to root
     *
     * @param root TreeNode
     * @return List 从下到上按层打印二叉树节点值
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (true) {
            List<Integer> list = new ArrayList<Integer>();
            Queue<TreeNode> tmpQ = new LinkedList<TreeNode>();
            levelQueue(queue, tmpQ, list);
            if (list.size() > 0) {
                stack.push(list);
            }
            if (tmpQ.isEmpty()) {
                break;
            }
            queue = tmpQ;
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        System.out.println(result);
        return result;
    }


    /**
     * 257. Binary Tree Paths
     * Given a binary tree, return all root-to-leaf paths.
     *
     * @param root TreeNode
     * @return List<String>
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        if (root != null) {
            findPath(root, String.valueOf(root.val), paths);
        }
        return paths;
    }

    private void findPath(TreeNode root, String val, List<String> paths) {
        if (root == null) return;
        if (root.left == null && root.right == null) paths.add(val);
        if (root.left != null) {
            findPath(root.left, val + "->" + root.left.val, paths);
        }
        if (root.right != null) {
            findPath(root.right, val + "->" + root.right.val, paths);
        }
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
     * 235. Lowest Common Ancestor of a Binary [Search] Tree
     * 二叉搜索树 有更方便的解法 bug-free
     * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
     *
     * @param root TreeNode
     * @param p    TreeNode
     * @param q    TreeNode
     * @return TreeNode
     */
    public TreeNode lowestCommonAncestorSearch(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        return lowestCommonAncestorValue(root, min, max);
    }

    public TreeNode lowestCommonAncestorValue(TreeNode root, int min, int max) {
        if (min <= root.val && max >= root.val) {
            return root;
        }
        if (max <= root.val) {
            return lowestCommonAncestorValue(root.left, min, max);
        } else {
            return lowestCommonAncestorValue(root.right, min, max);
        }
    }


    /**
     * 236. Lowest Common Ancestor of a Binary Tree
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     * 找出二叉树两个节点的最低公共祖先
     * 两个链表,找最后一个公共节点
     * 针对任意二叉树的通用解法
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

    //使用deque
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> list1 = new LinkedList<TreeNode>();
        Deque<TreeNode> list2 = new LinkedList<TreeNode>();
        findPath(root, p, list1);
        findPath(root, q, list2);
        TreeNode common = root;
        while (!list1.isEmpty() && !list2.isEmpty()) {
            TreeNode node1 = list1.removeLast();
            TreeNode node2 = list2.removeLast();
            if (node1 == node2) {
                common = node1;
            } else {
                break;
            }
        }
        return common;
    }


    /**
     * 剑指offer上最后一题
     * 2016-07-11 早上来了还是翻书参考才写出来
     * 二叉树递归遍历,用栈模拟 easy code
     *
     * @param root  TreeNode 根节点
     * @param p     TreeNode 目标节点
     * @param stack 栈
     * @return true/false
     */
    private boolean findPath(TreeNode root, TreeNode p, Stack<TreeNode> stack) {
        if (root == null)
            return false;
        if (root == p) {
            stack.push(root);
            return true;
        }
        boolean res = false;
        stack.push(root); //开始push
        if (root.left != null) {
            res = findPath(root.left, p, stack);
        }
        if (res) return true; //找到节点返回
        if (root.right != null) {
            res = findPath(root.right, p, stack);
        }
        if (!res) stack.pop(); //左右节点均没有找到,pop出来 最后pop 中间不对stack操作
        return res;
    }

    /**
     * 使用双向队列deque遍历
     *
     * @param root  TreeNode
     * @param p     TreeNode
     * @param deque deque 双向队列
     * @return true/false
     */
    private boolean findPath(TreeNode root, TreeNode p, Deque<TreeNode> deque) {
        if (root == null) return false;
        if (root == p) {
            deque.push(root);
            return true;
        }
        boolean res = false;
        deque.push(root);
        if (root.left != null) {
            res = findPath(root.left, p, deque);
        }
        if (res) return true;
        if (root.right != null) {
            res = findPath(root.right, p, deque);
        }
        if (!res) {
            deque.pop();
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
     * 根据输入的List构造二叉树,二叉堆
     * [1,2,3,4,5]
     * [1,2,null,3,null,4,null,5,null]
     *
     * @param list List<Integer>
     * @return head TreeNode
     */
    public TreeNode constructTree(List<Integer> list) {
        if (list == null || list.isEmpty()) return null;
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        TreeNode head = new TreeNode(list.get(0));
        treeNodes.add(head);
        int len = list.size();
        for (int i = 1; i < len; i++) {
            Integer val = list.get(i);
            if (val == null) {
                treeNodes.add(null);
            } else {
                treeNodes.add(new TreeNode(val));
            }
        }
        for (int i = 1; i < len; i++) {
            TreeNode parent = treeNodes.get((i - 1) / 2);
            if (parent != null) {
                if ((i & 1) != 0) {
                    //奇数
                    parent.left = treeNodes.get(i);
                } else {
                    //偶数
                    parent.right = treeNodes.get(i);
                }
            }
        }
        return head;
    }
}
