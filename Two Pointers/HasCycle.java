/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        //create two pointers at two positions
        ListNode slowPointer = head;

        ListNode fastPointer = head.next;

        while(slowPointer != fastPointer){
            if(fastPointer == null || fastPointer.next == null){
                return false;
            }

            //slow one with one pace
            slowPointer = slowPointer.next;
            //fast one with two paces
            fastPointer = fastPointer.next.next;
        }
        return true;
    }
}