/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        int left = 0;
        int maxSize = 0;
        for(int right = 0; right < cs.length; right++){
            // 通过出现元素，来控制左窗口
            if(map.containsKey(cs[right])){
                left = Math.max(left,map.get(cs[right]) + 1);
            }
            //每一次都会更新字符位置
            map.put(cs[right],right);
            maxSize = Math.max(maxSize,right - left + 1);
        }
        return maxSize;
    }
}
// @lc code=end

