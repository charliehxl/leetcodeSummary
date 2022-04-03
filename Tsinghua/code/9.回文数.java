import java.time.chrono.MinguoChronology;

/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        // 排除特殊情况
        if (x < 0 || (x % 10 == 0 && x != 0) ){
            return false;
        }
        int mirrorNum = 0;
        while (x > mirrorNum){
            mirrorNum = mirrorNum * 10 + x % 10;
            x /= 10;
        }
        return (x == mirrorNum || x == mirrorNum / 10);
    }
}
// @lc code=end

