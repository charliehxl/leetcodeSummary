/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {

    // 两种情况：一种无限循环，本身就是一个大环；一种最终趋向于 1，相当于在 1 无限循环
    public boolean isHappy(int n) {
        int slow = n;
        int fast = squareSum(n);
        while (slow != fast){
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        }
        return slow == 1;
    }

    public int squareSum(int n){
        int sum = 0;
        while (n > 0){
            int digit = n % 10;
            n /= 10;
            sum += digit * digit;
        }
        return sum;
    }
}
// @lc code=end

