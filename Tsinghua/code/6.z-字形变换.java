/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {

  public String convert(String s, int numRows) {
    if (numRows < 2) return s;

    char[] cs = s.toCharArray();
    List<StringBuilder> rows = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      rows.add(new StringBuilder());
    }
    int i = 0, flag = -1;
    for (char c : cs) {
      rows.get(i).append(c);
      if (i == 0 || i == numRows - 1) {
        flag = -flag;
      }
      i += flag;
    }

    StringBuilder ans = new StringBuilder();
    for (StringBuilder row : rows) ans.append(row);
    return ans.toString();
  }
}
// @lc code=end
