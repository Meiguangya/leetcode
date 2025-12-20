package main.java.hot100;

import main.java.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author meiguangya
 * @date 2025/12/20 下午12:23
 * @description 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 找出环形入口
 *
 */
public class HasCycle2 {


    /**
     * 最简单的方法，使用set集合 保存已经遍历过的节点 如果保存失败 说明节点重复 那么这个节点就是环的入口
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.add(head)) {
                head = head.next;
            } else {
                return head;
            }
        }
        return null;
    }


    /**
     * 使用快慢指针 找出第一次相遇的节点，然后
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {

        ListNode loopNode = getLoopNode(head);
        if (loopNode == null) {
            return null;
        }

        ListNode p = head;
        while (p != loopNode) {
            p = p.next;
            loopNode = loopNode.next;
        }

        return p;
    }

    private ListNode getLoopNode(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return fast;
            }
        }
    }


}

