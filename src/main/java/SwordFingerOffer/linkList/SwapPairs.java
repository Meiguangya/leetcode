package main.java.SwordFingerOffer.linkList;

/**
 * @author meiguangya
 * @date 2025/7/26 下午10:09
 * @description 两两交换链表中的节点
 *
 * 1 2 3 4 -> 2 1 4 3
 * 1 2 3 4 5 -> 2 1 4 3 5
 */
public class SwapPairs {


    public ListNode swapPairs(ListNode head) {

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode dummy = pre;

        while (pre.next != null) {
            ListNode curr = pre.next;
            ListNode node = curr.next;
            if(node == null){
                break;
            }
            curr.next = node.next;
            node.next = curr;
            pre.next = node;
            pre = curr;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        SwapPairs demo = new SwapPairs();
        ListNode listNode = demo.swapPairs(head);

    }


}
