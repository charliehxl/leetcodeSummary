/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {

  // 桶排序 -- 下标强绑定(nums[i] 应该放到 i - 1 位置)
  public int firstMissingPositive(int[] nums) {
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
        int temp = nums[nums[i] - 1];
        nums[nums[i] - 1] = nums[i];
        nums[i] = temp;
      }
    }

    for (int i = 0; i < len; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return len + 1;
  }
}
// @lc code=end
