package main.java.SwordFingerOffer.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author meiguangya
 * @date 2025/7/31 下午3:00
 * @description 设计一个最小栈 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 */
public class MinStack {

    List<Integer> list;
    int min = Integer.MAX_VALUE;
    ListNode dummy;

    public MinStack() {
        list = new ArrayList();
        dummy = new ListNode(0);
    }

    public void push(int val) {
        list.add(val);
        if (val <= min) {
            min = val;
            ListNode pre = dummy.next;
            dummy.next = new ListNode(min, list.size() - 1);
            dummy.next.next = pre;
        } else {
            ListNode curr = dummy.next;
            ListNode pre = dummy;
            while (curr != null && curr.val <= val) {
                pre = curr;
                curr = curr.next;
            }
            pre.next = new ListNode(val, list.size() - 1);
            pre.next.next = curr;
        }
    }

    public void pop() {
        int p = list.size() - 1;

        ListNode curr = dummy.next;
        ListNode pre = dummy;
        while (curr != null) {
            if (curr.position == p) {
                break;
            } else {
                pre = curr;
                curr = curr.next;
            }
        }

        pre.next = curr.next;

        list.remove(p);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        if (dummy.next == null) {
            return Integer.MAX_VALUE;
        }
        return dummy.next.val;
    }


    // 设计一个内部链表 从小到大
    class ListNode {
        int val;
        int position;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, int position) {
            this.val = val;
            this.position = position;
        }
    }


    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-1);
        int min1 = stack.getMin();
        stack.top();
        stack.pop();
        int min2 = stack.getMin();
    }

}

