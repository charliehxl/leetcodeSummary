/*
 * @lc app=leetcode.cn id=495 lang=java
 *
 * [495] 提莫攻击
 */

// @lc code=start
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int last = -1;  // 记录上次的终点
        for(int t : timeSeries){
            int end = t + duration - 1;
            if (t > last){
                ans += duration;    
            } else {
                ans += end - last;
            }
            last = end;
        }
        return ans;
    }
}
// @lc code=end

