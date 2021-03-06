/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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

    public ListNode recur(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val > list2.val) {
            list2.next = recur(list1, list2.next);
            return list2;
        } else {
            list1.next = recur(list1.next, list2);
            return list1;
        }
    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode l = list1, r = list2;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l != null && r != null) {
            if (l.val > r.val) {
                cur.next = r;
                r = r.next;
            } else {
                cur.next = l;
                l = l.next;
            }
            cur = cur.next;
        }
        cur.next = l == null ? r : l;
        return dummy.next;
    }
}
// @lc code=end
