/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        // 最开始前后指针 宽是最长的，高度以最短的决定
        int left = 0;
        int right = height.length - 1;

        int maxVal = 0;
        while (left < right){
            if (height[left] > height[right]){
                int area = (right - left) * height[right];
                maxVal = Math.max(area,maxVal);
                right--;
            }else{
                int area = (right - left) * height[left];
                maxVal = Math.max(area,maxVal);
                left++;
            }
        }
        return maxVal;
    }
}
// @lc code=end

