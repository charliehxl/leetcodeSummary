import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {

    public int romanToInt(String s){
        int sum = 0;
        int preNum = getVaule(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            int curNum = getVaule(s.charAt(i));
            if (preNum < curNum){
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = curNum;
        }
        return sum + preNum;
    }

    public int getVaule(char c){
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public int romanToInt1(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] cs = s.toCharArray();
        int res = 0;
        for(int i = 0; i < cs.length - 1; i++){
            if (map.get(cs[i]) < map.get(cs[i + 1])){
                res -= map.get(cs[i]);
            } else {
                res += map.get(cs[i]);
            }
        }
        return res + map.get(cs[cs.length - 1]);
    }
}
// @lc code=end

