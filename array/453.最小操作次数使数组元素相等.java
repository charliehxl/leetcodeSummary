/*
 * @lc app=leetcode.cn id=453 lang=java
 *
 * [453] 最小操作次数使数组元素相等
 */

// @lc code=start
class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i : nums){
            min = Math.min(i,min);
            sum += i;
        }
        return sum - min * nums.length;
    }
}
// @lc code=end

