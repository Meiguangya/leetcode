package main.java.SwordFingerOffer.linkList;

/**
 * @author meiguangya
 * @date 2025/7/26 下午10:23
 * @description 合并两个有序的链表
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while(list1 != null || list2 !=null){
            if(list1 == null){
                node.next = list2;
                break;
            }

            if(list2 == null){
                node.next = list1;
                break;
            }

            if(list1.val <= list2.val){
                node.next = list1;
                list1 = list1.next;
            }else{
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        return dummy.next;

    }


}
