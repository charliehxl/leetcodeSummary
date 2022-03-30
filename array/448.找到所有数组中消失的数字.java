/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if (nums[i] != i + 1){
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
// @lc code=end

