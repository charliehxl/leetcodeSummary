import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=697 lang=java
 *
 * [697] 数组的度
 */

// @lc code=start
class Solution {

  // 遍历 hashmap，key：遇到的值，value（出现次数，第一次出现的位置，第二次出现的位置）
  public int findShortestSubArray(int[] nums) {
    HashMap<Integer, int[]> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        // 出现过
        map.get(nums[i])[0]++;
        map.get(nums[i])[2] = i;
      } else {
        map.put(nums[i], new int[] { 1, i, i });
      }
    }

    int degree = 0;
    int minLen = 0;

    // 遍历 hashmap，统计出现次数最大的 key
    for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
      int[] detail = entry.getValue();
      if (detail[0] > degree) {
          degree = detail[0];
          minLen = detail[2] - detail[1] + 1;
      } else if (detail[0] == degree) {
          int newLen = detail[2] - detail[1] + 1;
          if (minLen > newLen){
              minLen = newLen;
          }
      }
    }
    return minLen;
  }
}
// @lc code=end
