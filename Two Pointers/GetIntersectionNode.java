/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode aNode = headA;
        ListNode bNode = headB;
        while (aNode != bNode) {
            aNode = aNode == null ? headB : aNode.next;
            bNode = bNode == null ? headA : bNode.next;
        }
        return aNode;
    }
}
