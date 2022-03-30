/*
 * @lc app=leetcode.cn id=274 lang=java
 *
 * [274] H 指数
 */

// @lc code=start
class Solution {
    public int hIndex1(int[] citations) {
        Arrays.sort(citations);
       int max = 0;
       int len = citations.length;
       for (int i = 0; i < len; i++){
           if (citations[i] >= len - i){
               max = Math.max(max,len - i);
           }
       }
       return max;
    }

    public int hIndex(int[] citations) {
        // 通过二分来猜论文数
        int len = citations.length;
        int left = 0;
        int right = len;
        while (left < right){
            int mid = (left + right + 1) / 2;
            if(check(citations,mid)){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }
    public boolean check(int[] nums, int h){
        int count = 0;
        for(int n : nums){
            if (n >= h){
                count++;
            }
        }
        return count >= h;
    }
}
// @lc code=end

