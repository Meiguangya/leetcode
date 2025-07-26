package main.java.SwordFingerOffer.linkList;

/**
 * @author meiguangya
 * @date 2025/7/26 下午5:17
 * @description 环形链表 并找出环形的入口
 */
public class DetectCycle {


    public ListNode detectCycle(ListNode head) {

        ListNode loopNode = getLoopNode(head);
        if (loopNode == null) {
            return null;
        }
        ListNode node = head;
        while (node != loopNode) {
            loopNode = loopNode.next;
            node = node.next;
        }

        return node;
    }

    public ListNode getLoopNode(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head, slow = head;

        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;

            if (fast == slow) {
                return fast;
            }
        }

        return null;
    }


}
