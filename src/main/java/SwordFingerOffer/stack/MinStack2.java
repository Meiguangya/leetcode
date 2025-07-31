package main.java.SwordFingerOffer.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author meiguangya
 * @date 2025/7/31 下午3:37
 * @description TODO
 */
public class MinStack2 {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack2() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStack2 stack = new MinStack2();
        stack.push(-2);
        stack.push(0);
        stack.push(-1);
        int min1 = stack.getMin();
        stack.top();
        stack.pop();
        int min2 = stack.getMin();
    }

}
