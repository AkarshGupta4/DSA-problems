
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        if(head.next == null){
            return null;
        }
        
        while(fast.next.next != null && fast.next.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // code me mid ko del karenge 

        slow.next = slow.next.next;
        return head;
    }
}