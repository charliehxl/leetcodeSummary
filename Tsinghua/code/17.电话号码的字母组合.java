/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {

    // 回溯算法
    // 格式：1、添加字符 2、递归 3、删除字符
    // 递归需要带上
    String[] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return res;
        }
        backtrace(digits, new StringBuilder(), 0);
        return res;
    }

    List<String> res = new ArrayList<>();
    public void backtrace(String digits, StringBuilder result,int index){
        if (index == digits.length()){
            res.add(result.toString());
            return;
        }

        int c = digits.charAt(index) - '0';
        String targetStr = map[c];
        for (int i = 0; i < targetStr.length();i++){
            result.append(targetStr.charAt(i));
            backtrace(digits, result, index + 1);
            result.deleteCharAt(result.length() - 1);
        }
    }

}
// @lc code=end

