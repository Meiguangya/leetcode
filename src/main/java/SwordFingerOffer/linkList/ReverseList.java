package main.java.SwordFingerOffer.linkList;

/**
 * @author meiguangya
 * @date 2025/7/26 下午5:39
 * @description 反转链表
 */
public class ReverseList {


    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode curr = head;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }

}
