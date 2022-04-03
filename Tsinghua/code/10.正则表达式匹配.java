/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;

        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][ n + 1];

        // 初始化
        dp[0][0] = true;
        for(int i = 2; i < n; i++){
            // #*#* 这种全部取 0 次重复
            if (p.charAt(i - 1) == '*' && dp[0][i - 2]){
                dp[0][i] = true;
            }
        }

        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                char curS = s.charAt(i - 1);
                char curP = p.charAt(j - 1);
                if (curP == curS || curP == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(curP == '*'){
                    // 看前面字符
                    char preCurP = p.charAt(j - 2);
                    if (preCurP != '.' && preCurP != curS){
                        dp[i][j] = dp[i][j - 2];
                    }else{
                        // 匹配 0、1、n 次 
                        // ######a(i)
                        // ####.*(j)  -- n 次的确有点难想到
                        dp[i][j] = (dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j]);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

