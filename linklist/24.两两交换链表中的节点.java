/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null)  return head;
        
        // 两个节点一组，小组内反转，小组外连接好前后指针
        // ListNode next = swapPairs(head.next.next);
        // ListNode tail = head.next;
        // tail.next = head;
        // head.next = next;
        // return tail;
        ListNode next = head.next;
        head.next = swapPairsRecursive(next.next);
        next.next = head;
        return next;
    }

    // 
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while(cur != null && cur.next != null){
            ListNode next = cur.next;
            
            pre.next = next;
            cur.next = next.next;
            next.next = cur;

            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
// @lc code=end

