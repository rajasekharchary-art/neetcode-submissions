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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int size = 0;
        ListNode curr = head;
        while(curr != null) { //  --> 1/1, 2/2, 3/3, 4/4
            size++;
            curr = curr.next;
        }

        int ntr = size - n;  //2

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        curr = head;
        int c = 0;
        while(null != curr) {  // -1 , 1, 2, 3, 4
            if(c == ntr) {
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
            c++;
        }

        return dummy.next;

    }
}
