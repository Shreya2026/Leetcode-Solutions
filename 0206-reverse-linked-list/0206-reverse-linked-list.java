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
    public ListNode reverseList(ListNode head) {
        //if(head==null) return head;    step 1
        ListNode prev=null;
        ListNode present=head;
       //ListNode next=present.next; if using this here then add step 1 too
        while(present!=null){
             ListNode next=present.next;
            present.next=prev;
            prev=present;
            present=next;
            if(next!=null) next=next.next;
        }
        return prev;
    }
}
