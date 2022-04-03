/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;

        // 处理前导空格
        int index = 0;
        while(index < len && cs[index] == ' '){
            index++;
        }
        if(index == s.length()){
            return 0;
        }

        //开始判断正负情况
        int flag = 1;
        if(cs[index] == '+'){
            index++;
        }else if(cs[index] == '-'){
            flag = -1;
            index++;
        }

        // 开始转换字符串，注意溢出
        int res = 0;
        while(index < len){
            char c = cs[index];
            if(c > '9' || c < '0'){
                break;
            }
            // 判断溢出
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && c - '0' > Integer.MAX_VALUE % 10) ){
                return Integer.MAX_VALUE;
            }
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && c - '0' > -(Integer.MIN_VALUE % 10) )){
                return Integer.MIN_VALUE;
            }
            res = res * 10 + flag * (c - '0');
            index++;
        }
        return res;
    }
}
// @lc code=end

