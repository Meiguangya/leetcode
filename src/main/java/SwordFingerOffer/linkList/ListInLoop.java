package main.java.SwordFingerOffer.linkList;

import lombok.extern.slf4j.Slf4j;

/**
 * @author meiguangya
 * @date 2025/7/26 下午4:21
 * @description 判断是否链表是否有环
 */
@Slf4j
public class ListInLoop {


    /**
     * 判断链表是否有环 如果没有返回null
     * @param head
     * @return
     */
    public ListNode getNodeInLoop(ListNode head) {

        if(head == null || head.next == null){
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head;

        while (p1 != null) {
            p1 = p1.next;
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
            p2 = p2.next;

            if(p1 == p2){
                return p1;
            }
        }

        return null;
    }

    public ListNode getNodeInLoop2(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head.next;
        ListNode fast = slow.next;

        while (slow != null && fast != null) {
            if (slow == fast) {
                return slow;
            }

            slow = slow.next;
            fast = fast.next;

            if (fast != null) {
                fast = fast.next;
            }

        }

        return null;
    }

    public int circularSize(ListNode head){
        ListNode nodeInLoop = getNodeInLoop(head);

        int count = 1;
        ListNode node = nodeInLoop.next;
        while(node != nodeInLoop){
            node = node.next;
            count ++;
        }

        return count;

    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;


        ListInLoop demo = new ListInLoop();

        ListNode nodeInLoop = demo.getNodeInLoop(head);
        //ListNode nodeInLoop = demo.getNodeInLoop2(head);
        log.info("node:[{}]",nodeInLoop);

        int i = demo.circularSize(head);
        log.info("circularSize:[{}]",i);

    }


}
