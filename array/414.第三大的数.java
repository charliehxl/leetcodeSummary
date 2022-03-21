/*
 * @lc app=leetcode.cn id=414 lang=java
 *
 * [414] 第三大的数
 */

// @lc code=start
class Solution {

  public int thirdMax(int[] nums) {
    long INF = (long) -1e18;
    long a = INF, b = INF, c = INF;
    for (int num : nums) {
      if (num > a) {
        c = b;
        b = a;
        a = num;
      } else if (num < a && num > b) {
        c = b;
        b = num;
      } else if (num < b && num > c) {
        c = num;
      }
    }
    return c != INF ? (int) c : (int) a;
  }
}
// @lc code=end
