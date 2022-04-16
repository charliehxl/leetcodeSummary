/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
  List<String> ans = new ArrayList<String>();
  //使用 StringBuilder 共用一个对象，会出现 ["((()))","((())))())",...]
  public List<String> generateParenthesis(int n) {
    recur(n, 0, 0, "");
    return ans;
  }

  public void recur(int n, int lb, int rb, String res) {
    // 边界条件
    if (lb == n && rb == n) {
      ans.add(res);
      return;
    }

    if (lb < n) {
      recur(n, lb + 1, rb, res + "(");
    }
    if (rb < n && lb > rb) {
      recur(n, lb, rb + 1, res + ")");
    }
  }
}
// @lc code=end
