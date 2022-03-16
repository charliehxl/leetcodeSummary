/*
 * @lc app=leetcode.cn id=406 lang=java
 *
 * [406] 根据身高重建队列
 */

// @lc code=start
class Solution {
    // 先排序，后插队 -- 想着通过排序解决问题，不是找 peach
    public int[][] reconstructQueue(int[][] people) {
        // 先排身高，再拍序号
        Arrays.sort(people,(a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        // 通过链表完成插队
        LinkedList<int[]> ans = new LinkedList<>();
        for(int[] p : people){
            ans.add(p[1],p);
        }
        return ans.toArray(new int[0][0]);
    }
}
// @lc code=end

