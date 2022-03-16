/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    // 重复元素全部删除
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while(head != null){
            if (head.next == null || head.next.val != head.val){
                tail.next = head;
                tail = head;
            }
            while(head.next != null && head.next.val == head.val){
                head = head.next;
            }
            head = head.next;
        }
        tail.next = null;
        return dummy.next;
    }
}
// @lc code=end

