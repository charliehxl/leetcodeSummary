/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    
    // 最长前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        
        String result = strs[0];
        for (int i = 1; i < strs.length; i++){
            result = longestCommonPrefixBetween(result, strs[i]);
            if(result == ""){
                break;
            }
        }
        return result;
    }

    public String longestCommonPrefixBetween(String s1,String s2){
        int minLen = s1.length() > s2.length() ? s2.length() : s1.length();
        int i = 0;
        while(i < minLen && s1.charAt(i) == s2.charAt(i)){
            i++;
        }
        return s1.substring(0, i);
    }
}
// @lc code=end

