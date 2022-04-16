/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeRecur(lists, 0, lists.length - 1);
    }

    // 核心思想：先分再合 -- 合：两个节点相并；数组通过下标分
    public ListNode mergeRecur(ListNode[] lists,int left, int right){
        if(left >= right) return lists[left];

        int mid = (left + right) / 2;
        ListNode leftNode =  mergeRecur(lists,left, mid);
        ListNode rightNode = mergeRecur(lists,mid + 1, right);
        return mergeTwo(leftNode, rightNode);
    }

    public ListNode mergeTwo(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(l1 != null && l2 != null){
            if (l1.val > l2.val){
                tail.next = l2;
                l2 = l2.next;
            }else{
                tail.next = l1;
                l1 = l1.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
// @lc code=end

