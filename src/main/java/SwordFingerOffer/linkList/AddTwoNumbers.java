package main.java.SwordFingerOffer.linkList;

/**
 * @author meiguangya
 * @date 2025/7/26 下午8:09
 * @description 两数相加
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int l = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int n = n1 + n2 + l;
            int v;
            if (n >= 10) {
                v = n - 10;
                l = 1;
            } else {
                l = 0;
                v = n;
            }
            curr.next = new ListNode(v);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            curr = curr.next;
        }

        // 别忘了最后的进位
        if (l == 1) {
            curr.next = new ListNode(1);
        }

        return dummy.next;

    }


}
