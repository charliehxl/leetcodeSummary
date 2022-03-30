/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] 数组中重复的数据
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < len; i++){
            int index = (nums[i] - 1) % len;
            nums[index] += len;
            if (nums[index] > 2 * len){
                ans.add(index + 1);
            }
        }
        return ans;
    }
}
// @lc code=end

