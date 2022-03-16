/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        // 找到小组末尾节点的后一个节点，方便节点内反转
        int count = 0;
        ListNode cur = head;
        while (cur != null && count < k) {
            cur = cur.next;
            count++;
        }
        if (count != k)
            return head;

        //  得先反转再递归，不然递归回来，再来处理这一层逆转需求，head.next 就不对了。
        // head.next = reverseKGroup(cur, k);
        // return reverseBetweenNodes(head, cur);
        
        ListNode newHead = reverseBetweenNodes(head, cur);
        head.next = reverseKGroup(cur, k);
        return newHead;
    }

    // 这里的 tail 实际上是小组末尾节点的后一个节点（非小组内节点）
    public ListNode reverseBetweenNodes(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
// @lc code=end
