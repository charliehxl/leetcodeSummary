/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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

    // 链表本身就是层层向下的，一般先处理完后节点，再处理前节点，这样还能操作后节点
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)  return head;
        head.next = partition(head.next, x);

        if(head.val >= x && head.next.val < x){
            ListNode newNode = head.next;
            ListNode ptr = head;
            while (ptr.next != null && ptr.next.val < x){
                ptr = ptr.next;
            }
            head.next = ptr.next;
            ptr.next = head;
            return newNode;
        }else{
            return head;
        }
    }
}
// @lc code=end

