package main.java.entity;

/**
 * @author meiguangya
 * @date 2024/12/30 上午10:55
 * @description TODO
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
