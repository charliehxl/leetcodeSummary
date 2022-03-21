/*
 * @lc app=leetcode.cn id=645 lang=java
 *
 * [645] 错误的集合
 */

// @lc code=start
class Solution {

  //老老实实用 hash
  public int[] findErrorNums1(int[] nums) {
    int n = nums.length;
    int[] flag = new int[n + 1];
    for (int x : nums) {
      flag[x]++;
    }
    int[] res = new int[2];
    for (int i = 1; i <= n; i++) {
      if (flag[i] == 0) {
        res[1] = i;
      } else if (flag[i] == 2) {
        res[0] = i;
      }
    }
    return res;
  }

  // 1 + .. + n 是个固定值total，通过 set 加完全部值set
  public int[] findErrorNums2(int[] nums) {
    int n = nums.length;
    int[] flag = new int[n + 1];
    int total = n * (n + 1) / 2;
    int sum = 0;
    int set = 0;
    for (int x : nums) {
      sum += x;
      if (flag[x] == 0) set += x;
      flag[x] = 1;
    }
    return new int[] { sum - set, total - set };
  }

  // 利用桶排序  -- 为啥不用 sort 排序，是因为出现 2334 这种，桶排序可以是 3234
  // 这种能保证 nums[i] = i + 1
  public int[] findErrorNums(int[] nums) {
      for (int i = 0; i < nums.length; i++){
          while(nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]){
              int temp = nums[nums[i] - 1];
              nums[nums[i] - 1] = nums[i];
              nums[i] = temp;
          }
      }
      int a = -1, b = -1;
      for(int i = 0; i < nums.length; i++){
          if(nums[i] != i + 1){
              a = nums[i];
              b = i == 0 ? 1 : nums[i - 1] + 1;
          }
      }
      return new int[]{a,b};
  }
}
// @lc code=end
