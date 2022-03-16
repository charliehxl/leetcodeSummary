/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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

    public ListNode rotateRight(ListNode head, int k) {
        /**
         * 1.get the length of linklist
         * 2.move to the (l - n % l)th node
         * 3.Do the rotation
         */
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 1
        int len;
        for (len = 0; fast.next != null; len++) {
            fast = fast.next;
        }

        // 2
        for (int j = len - k % len; j > 0; j--) {
            slow = slow.next;
        }

        // 3
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }

    public ListNode rotateRight_My(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        // 取余 减少旋转操作
        int len = linklistLen(head);
        int rotateTimes = k % len;
        if (rotateTimes == 0)
            return head;

        // 通过双指针完成旋转
        ListNode pre = head;
        ListNode cur = head;
        int count = rotateTimes;
        while (count > 0) {
            cur = cur.next;
            count--;
        }
        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }

        ListNode newHead = pre.next;
        pre.next = null;
        cur.next = head;
        return newHead;
    }

    public int linklistLen(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}
// @lc code=end
