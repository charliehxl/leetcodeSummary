/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        boolean[][] dp = new boolean[len][len];
        // 初始化单个字符串为 true
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }

        int maxLen = 1;
        int begin = 0;
        for(int j = 1; j < len; j++){
            for(int i = 0; i < j; i++){
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else{
                    // 考虑边界条件(j-1) - (i + 1) >= 1
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                //出现 true 且 长度大于目前最大值
                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        //左闭右开
        return s.substring(begin,begin + maxLen);
    }
}
// @lc code=end

