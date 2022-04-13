import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {

    // 先排序，三指针
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 2) return res;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++){
            if (nums[i] > 0) break;
            if (i > 0 && nums[i - 1] == nums[i]) continue;

            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum == target){
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    //避免重复处理 -- 先向内收紧，然后保证左右数字和上次数字不一样
                    left++;
                    right--;
                    while(left < right && nums[left - 1] == nums[left]){
                        left++;
                    }
                    while (left < right && nums[right + 1] == nums[right]){
                        right--;
                    }

                }else if(sum > target){
                    right--;
                }else if(sum < target){
                    left++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

