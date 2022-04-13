import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {

    // 贪心策略 先捡大的减
    public String intToRoman(int num) {
        int[] subNum = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        int index = 0;
        StringBuilder result = new StringBuilder();
        while(index < 13){
            while(num >= subNum[index]){
                num -= subNum[index];
                result.append(roman[index]);
            }
            index += 1;
        }
        return result.toString();
    }
}
// @lc code=end

