import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList1(Node head) {
        HashMap<Node,Node> nodeMap = new HashMap<>();
        // 复制节点
        Node cur = head;
        Node dummy = new Node(-1);
        Node tail = dummy;
        // 复制
        while (cur != null){
            Node newNode = new Node(cur.val);
            tail.next = newNode;
            tail = tail.next;
            nodeMap.put(cur,newNode);

            cur = cur.next;
        }

        // 处理random 节点
        cur = head;
        tail = dummy.next;
        while (cur != null){
            if (cur.random != null){
                tail.random = nodeMap.get(cur.random);
            }
            cur = cur.next;
            tail = tail.next;
        }
        return dummy.next;
    }

    public Node copyRandomList(Node head) {
        //复制节点 -- cur.next != null 代表到达最后一个节点不处理（复制显然不行）
        Node cur = head;
        while (cur != null){
            Node newNode = new Node(cur.val);
            Node next = cur.next;
            newNode.next = next;
            cur.next = newNode;
            
            cur = next;
        }
        // 处理 random节点
        cur = head;
        while (cur != null){
            Node toRandom = cur.next;
            if(cur.random != null){
                toRandom.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 间隔拆分
        Node dummy = new Node(-1);
        Node tail = dummy;
        cur = head;
        while (cur != null){
            Node next = cur.next.next;
            tail.next = cur.next;
            tail = tail.next;
            cur.next = next;
            cur = next;
        }
        return dummy.next;
    }
}
// @lc code=end

