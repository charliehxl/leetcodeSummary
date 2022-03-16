
/*
 * @lc app=leetcode.cn id=707 lang=java
 *
 * [707] 设计链表
 */

// @lc code=start
// 单链表
class MyLinkedList1 {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node dummy;
    // Node tail;  -- 增删代价有点大 通过添加 size 来减少
    int size;
    public MyLinkedList1() {
        dummy = new Node(-1);
        size = 0;
    }

    // 查
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node cur = dummy;
        while (cur != null && index >= 0){
            cur = cur.next;
            index -= 1;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
       this.addAtIndex(0, val);
    }

    public void addAtTail(int val) {
       this.addAtIndex(size, val);
    }

    //增
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0){
            index = 0;
        }

        Node seek = dummy;
        while(seek != null && index > 0){
            seek = seek.next;
            index -= 1;
        }
        Node newNode = new Node(val);
        newNode.next = seek.next;
        seek.next = newNode;
        size += 1;
    }

    // 删
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size)   return;
        Node seek = dummy;
        while(seek != null && index > 0){
            seek = seek.next;
            index -= 1;
        }
        seek.next = seek.next.next;
        size -= 1;
    }
}

//双链表
class MyLinkedList {
    class ListNode {
        int val;
        ListNode next,prev;
        ListNode(int x) {val = x;}
    }

    int size;
    ListNode head,tail;//Sentinel node

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size){return -1;}
        ListNode cur = head;

        // 通过判断 index < (size - 1) / 2 来决定是从头结点还是尾节点遍历，提高效率
        if(index < (size - 1) / 2){
            for(int i = 0; i <= index; i++){
                cur = cur.next;
            }            
        }else{
            cur = tail;
            for(int i = 0; i <= size - index - 1; i++){
                cur = cur.prev;
            }
        }
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        this.addAtIndex(0, val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        this.addAtIndex(size, val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size){return;}
        if(index < 0){index = 0;}
        ListNode cur = head;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next.prev = newNode;
        newNode.prev = cur;
        cur.next = newNode;
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= size || index < 0){return;}
        ListNode cur = head;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.next.next.prev = cur;
        cur.next = cur.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end
