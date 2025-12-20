package main.java.hot100;

import main.java.entity.ListNode;

/**
 * @author meiguangya
 * @date 2025/12/20 下午7:39
 * @description 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -10的5次方 <= Node.val <= 10的5次方
 */
public class LinkedListSort {


    /**
     * 使用一个新的链表 遍历原始链表 将原始链表的节点与新链表的节点一个个比较 塞入正确的位置
     * 时间复杂度太高
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        ListNode pre = new ListNode(0);

        ListNode p = head;

        while (p != null) {

            ListNode n = new ListNode(p.val);
            ListNode i = pre;
            while (i.next != null && i.next.val < n.val) {
                i = i.next;
            }

            ListNode temp = i.next;
            i.next = n;
            n.next = temp;

            p = p.next;
        }

        return pre.next;
    }

    /**
     * 使用递归方式，将链表拆成成两半 然后将两个链表合并
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        return sortListByRange(head, null);
    }

    /**
     * 返回从head到tail范围内有序的链表
     * 终止条件 这个链表就一个节点，或者这个链表是空
     * 否则 将这个链表进行拆办，然后返回两个有序链表的合并
     *
     * @param head
     * @param tail
     * @return
     */
    public ListNode sortListByRange(ListNode head, ListNode tail) {

        if (head == null) {
            return null;
        }

        if (head.next == tail) {
            head.next = null;
            return head;
        }

        // 将链表分为两部分
        ListNode slow = head;
        ListNode fast = head;

        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode l1 = sortListByRange(head, mid);
        ListNode l2 = sortListByRange(mid, tail);
        return mergeTwoLists(l1, l2);

    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode node = new ListNode(0);
        ListNode dummyHead = node;

        while (list1 != null || list2 != null) {

            if (list1 == null) {
                node.next = list2;
                break;
            }

            if (list2 == null) {
                node.next = list1;
                break;
            }

            if (list1.val > list2.val) {
                node.next = list2;
                node = node.next;
                list2 = list2.next;
            } else {
                node.next = list1;
                node = node.next;
                list1 = list1.next;
            }

        }

        return dummyHead.next;
    }


    public static void main(String[] args) {

        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        LinkedListSort demo = new LinkedListSort();

        ListNode ret = demo.sortList(n1);
        System.out.println(ret.val);
    }

}
