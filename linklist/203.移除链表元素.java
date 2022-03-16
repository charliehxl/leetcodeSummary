/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        while (pre != null && pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }

    // 递归 -- 从前到后 逐级递归
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;

        if(head.val != val){
            head.next = removeElements(head.next, val);
            return head;
        }else{
            // 快速找到不等的节点
            while(head != null && head.val == val){
                head = head.next;
            }
            return removeElements(head, val);
        }
        
    }

    // 从后往前
    public ListNode removeElements2(ListNode head, int val) {
        if(head == null) return head;

        head.next = removeElements2(head.next, val);
        if(head.val == val){
            return head.next;
        }else{
            return head;
        }

    }

}
// @lc code=end
