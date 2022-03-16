/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续 1 的个数
 */

// @lc code=start
class Solution {


    // 窗口函数
    public int findMaxConsecutiveOnes(int[] nums) {
        return count(nums);
    }

    // 直接
    public int count(int[] nums) {
        int count = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                max = Math.max(max,count);
                count = 0;
            }
        }
        return Math.max(max,count);
    }

    // 窗口函数
    public int slidingWindow(int[] nums) {
        int left = 0;
        int right = 0;
        int maxSize = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                maxSize = Math.max(maxSize, right - left);
                // 窗口闭合
                right += 1;
                left = right;
            } else {
                right++;
            }

        }
        return Math.max(maxSize, right - left);
    }

}
// @lc code=end
