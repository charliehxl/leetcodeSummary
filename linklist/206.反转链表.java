
/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
        return recur(head);
    }

    public ListNode recur(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode tail = recur(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }

    public ListNode noRecusive(ListNode head){
        if(head == null || head.next == null)   return head;
        // pre = null 就能避免头结点需要指向为 null 的特例情况
        ListNode pre = null, cur = head;
        // 非递归从开始向末尾开始，而递归则是从末尾向开始逆转，系统通过栈完成节点的记录
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            
            //移动
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
// @lc code=end

