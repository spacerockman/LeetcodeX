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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null || val < 0){
            return null;
        }

        //设置新的节点,因为要对比的是curr的下一个节点的值是否和目标的val相等，所以条件是curr.next
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        while(curr.next != null ){
            if(curr.next.val == val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}