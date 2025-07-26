package main.java.SwordFingerOffer.linkList;

import lombok.extern.slf4j.Slf4j;

/**
 * @author meiguangya
 * @date 2025/7/26 下午3:46
 * @description 给定一个链表 删除链表中的倒数第K个节点
 * <p>
 * 1>2>3>4>5>6   k = 2 那么删除倒数第二个节点 5
 * 变成 1>2>3>4>6
 */
@Slf4j
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p1 = head;
        ListNode p2 = dummy;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        while(p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }

        if (p2.next == null) {
            return null;
        }
        p2.next = p2.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd demo = new RemoveNthFromEnd();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode ret = demo.removeNthFromEnd(head, 4);

        log.info("{}",ret);

    }


}
