/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    // 通过遍历
    int res = 0;
    public int maxDepth(TreeNode root) {
        maxDepthTranverse(root, 0);
        return res;
    }

    public void maxDepthTranverse(TreeNode root,int depth){
        if (root == null){
            res = Math.max(res,depth);
            return;
        }
        maxDepthTranverse(root.left, depth + 1);
        maxDepthTranverse(root.right, depth + 1);
    }
    
    // // 分解问题  -- 自底向上
    // public int maxDepth(TreeNode root){
    //     if (root == null){
    //         return 0;
    //     }

    //     int lMax = maxDepth(root.left);
    //     int rMax = maxDepth(root.right);
    //     int res = Math.max(lMax,rMax) + 1;
    //     return res;
    // }
}
// @lc code=end

