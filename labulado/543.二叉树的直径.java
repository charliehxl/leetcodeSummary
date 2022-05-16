/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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

    //本质上就是遍历每个节点，计算该节点的左右最大深度之和
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return res;
    }
    
    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int lMax = maxDepth(root.left);
        int rMax = maxDepth(root.right);
        // 计算当前节点
        res = Math.max(res, lMax + rMax);
        return Math.max(lMax,rMax) + 1;
    }

}
// @lc code=end

