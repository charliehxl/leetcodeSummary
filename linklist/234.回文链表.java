/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode cur = null;
    public boolean isPalindrome(ListNode head) {
        cur = head;
        return dfs(head);
    }

    public boolean dfs(ListNode head){
        if(head == null) return true;
        boolean res = dfs(head.next) && (head.val == cur.val);
        if (!res) return false;
        cur = cur.next;
        return res;
    }
}
// @lc code=end

