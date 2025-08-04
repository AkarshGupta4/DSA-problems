class Solution {
    public LinkNode reverseList(LinkNode head){
        LinkNode prev = null;
        LinkNode current = head;

        while(current != null){
            LinkNode next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }
}