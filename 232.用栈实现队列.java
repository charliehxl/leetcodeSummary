import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {
    
    Deque<Integer> stackin;
    Deque<Integer> stackout;
    public MyQueue() {
        stackin = new ArrayDeque<>();
        stackout = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stackin.push(x);
    }
    
    public int pop() {
        if (!stackout.isEmpty()){
            return stackout.pop();
        }
        
        while(!stackin.isEmpty()){
            stackout.push(stackin.pop());
        }
        return stackout.isEmpty() ? -1 : stackout.pop();
    }
    
    public int peek() {
        if (!stackout.isEmpty()){
            return stackout.peek();
        }
        while(!stackin.isEmpty()){
            stackout.push(stackin.pop());
        }
        return stackout.isEmpty() ? -1 : stackout.peek();
        
    }
    
    public boolean empty() {
        return stackin.isEmpty() && stackout.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

