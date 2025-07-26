package main.java.SwordFingerOffer.linkList;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author meiguangya
 * @date 2025/7/26 下午5:44
 * @description 相交链表
 */
public class IntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Stack<ListNode> stackA = new Stack<>();
        ListNode nodeA = headA;
        while (nodeA != null) {
            stackA.push(nodeA);
            nodeA = nodeA.next;
        }

        Stack<ListNode> stackB = new Stack<>();
        ListNode nodeB = headB;
        while (nodeB != null) {
            stackB.push(nodeB);
            nodeB = nodeB.next;
        }

        nodeA = stackA.peek();
        nodeB = stackB.peek();
        ListNode n = null;

        while (nodeA == nodeB) {
            n = nodeA;
            nodeA = stackA.pop();
            nodeB = stackB.pop();
        }

        return n;

    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        // 使用hash表
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        ListNode ret = null;
        while (headB != null) {
            if (set.contains(headB)) {
                ret = headB;
                break;
            }

            headB = headB.next;
        }
        return ret;
    }


}
