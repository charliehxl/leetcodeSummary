import java.util.Iterator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=341 lang=java
 *
 * [341] 扁平化嵌套列表迭代器
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private Iterator<Integer> res;
    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> list = new LinkedList<>();
        for (NestedInteger root : nestedList){
            traverse(root,list);
        }
        this.res = list.iterator();
    }

    private void traverse(NestedInteger root, List<Integer> list){
        // 到达叶子节点
        if (root.isInteger()){
            list.add(root.getInteger());
            return;
        }
        for(NestedInteger node : root.getList()){
            traverse(node, list);
        }
    }

    @Override
    public Integer next() {
        return res.next();
    }

    @Override
    public boolean hasNext() {
       return res.hasNext(); 
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end

