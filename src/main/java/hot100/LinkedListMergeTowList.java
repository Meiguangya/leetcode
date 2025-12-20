package main.java.hot100;

import main.java.entity.ListNode;

/**
 * @author meiguangya
 * @date 2025/12/20 下午8:10
 * @description 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class LinkedListMergeTowList {


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

    /**
     * 使用递归写法
     * 终止条件 链表为空
     * 否则取小数的节点->小数节点的下一个节点和另一个链表的合并
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2){

        if(list1 == null){
            return list2;
        }else if(list2==null){
            return list1;
        }else if(list1.val > list2.val){
            list2.next = mergeTwoLists2(list2.next,list1);
            return list2;
        }else{
            list1.next = mergeTwoLists2(list1.next,list2);
            return list1;
        }

    }

}
