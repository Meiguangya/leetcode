package main.java.hot100;

import main.java.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author meiguangya
 * @date 2025/12/20 下午12:03
 * @description 给你一个链表的头节点 head ，判断链表中是否有环。
 */
public class HasCycle {

    /**
     * 使用快慢指针 如果快慢指针相遇 那么链表中肯定有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        if(head == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }

        }
    }


    /**
     * 使用哈希表 记录已经遍历过的节点 如果遍历结束之前 表中存在了已经遍历过的节点 那么有环
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {

        ListNode p = head;

        Set<ListNode> hashSet = new HashSet<>();

        while (p != null) {
            if (hashSet.add(p)) {
                p = p.next;
            }else{
                return true;
            }
        }

        return false;
    }


}
