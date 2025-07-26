package main.java.SwordFingerOffer.linkList;

import java.util.Stack;

/**
 * @author meiguangya
 * @date 2025/7/26 下午9:34
 * @description 回文链表
 */
public class Palindrome {

    public boolean isPalindrome(ListNode head) {

        Stack<ListNode> stack = new Stack<>();

        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }

        while (head != null) {
            if (head != stack.pop()) {
                return false;
            }
        }

        return true;

    }




}
