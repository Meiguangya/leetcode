package main.java.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author meiguangya
 * @date 2025/12/26 下午9:26
 * @description 随机链表的复制
 * <p>
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，
 * 其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，
 * 并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 */
public class LinkNodeCopyRandomList {


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        Node dummyHead = new Node(0);
        Node oldHead = head;

        Node tmp = dummyHead;
        while (head != null) {
            Node node = new Node(head.val);
            tmp.next = node;
            map.put(head, node);
            head = head.next;
            tmp = tmp.next;
        }

        Node newHead = dummyHead.next;
        while (oldHead != null) {
            if (oldHead.random != null) {
                newHead.random = map.get(oldHead.random);
            } else {
                newHead.random = null;
            }
            oldHead = oldHead.next;
            newHead = newHead.next;
        }


        return dummyHead.next;
    }

    public static void main(String[] args) {


        LinkNodeCopyRandomList l = new LinkNodeCopyRandomList();

        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2; n1.random = null;
        n2.next = n3; n2.random = n1;
        n3.next = n4; n3.random = n5;
        n4.next = n5; n4.random = n3;
        n5.next = null; n5.random = n1;

        Node node = l.copyRandomList(n1);
        System.out.println("over");
    }


}
