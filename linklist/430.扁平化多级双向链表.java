/*
 * @lc app=leetcode.cn id=430 lang=java
 *
 * [430] 扁平化多级双向链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {

    // 想在原函数直接递归，只能返回处理好的头结点
    public Node flatten1(Node head) {
        Node dummy = new Node(-1);
        dummy.next = head;

        // 开始一层一层处理
        while(head != null){
            if(head.child == null){
                head = head.next;
            }else{
                Node childHead = flatten1(head.child);
                //需要找末尾节点连接
                Node next = head.next;
                head.next = childHead;
                childHead.prev = head;
                head.child = null;
                while(head.next != null) head = head.next;
                head.next = next;
                if(next != null) next.prev = head;
                head = next;
            }
        }        
        return dummy.next;
    }

    // 直接将原函数 head 返回去，别动 head 节点，这样每层递归可以直接返回 last 节点
    public Node flattenByDFS(Node head) {
        dfs(head);
        return head;
    }

    // 返回末尾节点
    public Node dfs(Node head){
        Node last = head;
        while(head != null){
            if(head.child == null){
                last = head;
                head = head.next; 
            }else{
                Node childLast = dfs(head.child);
                // 通过child 完成头结点相连接
                Node next = head.next;
                head.child.prev = head;
                head.next = head.child;
                head.child = null;

                childLast.next = next;
                if (next != null) next.prev = childLast;
                last = childLast;
                head = next;
            }
        }
        return last;
    }

    // 迭代就是一层一层移上来
    public Node flatten(Node head){
        Node dummy = new Node(-1);
        dummy.next = head;
        while(head != null){
            if(head.child != null){
                Node next = head.next;
                Node child = head.child;
                head.child = null;

                head.next = child;
                child.prev = head;
                Node ptr = head;
                while(ptr.next != null){
                    ptr = ptr.next;
                }
                ptr.next = next;
                if(next != null) next.prev = ptr;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
// @lc code=end

