/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){
                stack.push(')');
            }else if (c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == ')' || c == ']' || c == '}'){
                if(stack.isEmpty() || c != stack.pop()){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

