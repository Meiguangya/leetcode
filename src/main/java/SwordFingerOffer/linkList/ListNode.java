package main.java.SwordFingerOffer.linkList;

/**
 * @author meiguangya
 * @date 2025/7/26 下午3:23
 * @description 单向链表节点
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }


    public ListNode append(ListNode head, int val) {

        if (head == null) {
            return new ListNode(val);
        }

        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }

        node.next = new ListNode(val);

        return head;
    }


    public ListNode append2(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode node = dummyNode;
        while(node.next!=null){
            node = node.next;
        }

        node.next = new ListNode(val);

        return dummyNode.next;
    }


    // 删除第一个值为val的节点
    public ListNode delete(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return head.next;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }

        return head;
    }

    public ListNode delete2(ListNode head, int value) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode node = dummy;
        while (node.next != null) {
            if (node.next.val == value) {
                node.next = node.next.next;
                break;
            }

            node = node.next;
        }

        return dummy.next;
    }


}
