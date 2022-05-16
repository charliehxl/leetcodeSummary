import java.util.Deque;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    //非递归写法 -- 模拟栈
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null){
            if (root != null){
                // 
                stack.push(root);
                root = root.left;
            }else{
                // 出栈 第二次访问
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                root = tmp.right;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorder(root, res);
        return res;
    }
    
    public void inorder(TreeNode root, List<Integer> res){
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
// @lc code=end

