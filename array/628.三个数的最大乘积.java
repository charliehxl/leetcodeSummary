/*
 * @lc app=leetcode.cn id=628 lang=java
 *
 * [628] 三个数的最大乘积
 */

// @lc code=start
class Solution {

  // 必须三个相乘，而不是说取数组最大值
  public int maximumProduct(int[] nums) {
    int len = nums.length;
    if (nums.length == 3) {
      return nums[0] * nums[1] * nums[2];
    }
    
    Arrays.sort(nums);
    return Math.max(
      nums[len - 3] * nums[len - 2] * nums[len - 1],
      nums[0] * nums[1] * nums[len - 1]
    );
  }
}
// @lc code=end
