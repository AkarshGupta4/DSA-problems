import java.util.List;

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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }

        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        ListNode temp = head;

        while(temp != wloe){
            list.add(temp.val);
            temp = temp.next; 
        }

        while(temp != null){
            list2.add(temp.val);
            temp = temp.next;
        }

        collection .reverse(list2);

        List<Integer> mergeList= new ArrayList<>();
        
        int i=0;
        int j=0;

        while(i<list.size() || j<list2.size()){
            if(i<list.size()){
                mergeList.add(list.get(i));
                i++;
            }

            if(j<list2.size()){
                mergeList.add(list2.get(j));
                j++;
            }

        }

        temp = head;
        int idx = 0;
        
        while(temp !=null){
            temp.val = mergerList.get(idx++);
            temp = temp.next;
        }
    }
}