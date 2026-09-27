/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        int sum = 0;
        int carry = 0;
        while(null != l1 || null != l2 || carry != 0) {
            sum = 0;
            if(l1 != null && l2 != null) {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if(l2 != null) {
                sum = l2.val + carry;
                l2 = l2.next;
            } else if( l1 != null) {
                sum = l1.val + carry;
                l1 = l1.next;
            }  else if ( null == l1 && null == l2) {
                sum = carry;
            }
            carry = sum / 10;
            if( sum >= 10) {
                sum = sum % 10;
            }
            ListNode curr = new ListNode(sum);
            prev.next = curr;
            prev = curr;

        }

        return dummy.next;
    }
}
