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
      if(head == null){
        return null;
      }

      //设置dummy(pre head)
      ListNode dummy = null;
      //从head节点开始指向前一个，知道curr为null
      ListNode curr = head;
      while(curr != null){
        //移动用准备一个curr的下一个节点
        ListNode next = curr.next;
        //改变指针方向
        curr.next = dummy;
        //向前移动
        dummy = curr;
        curr = next;
      }
      return dummy;
    }
}