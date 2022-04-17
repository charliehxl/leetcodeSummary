/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int pre = 1;
        for (int cur = 1; cur < nums.length; cur++){
            if (nums[cur] != nums[pre - 1]){
                nums[pre++] = nums[cur];
            }
        }
        return pre;
    }

    // 80题：每个元素 最多出现两次 
    public int keep2Duplicates(int[] nums,int k){
        int pre = 0;
        for (int cur = 0; cur < nums.length; cur++){
            // pre 始终停在目标数组最后一位，cur 游走
            if(pre < k || nums[cur] != nums[pre - k]){
                nums[pre++] = nums[cur];
            }
        }
        return pre;
    }
}
// @lc code=end

