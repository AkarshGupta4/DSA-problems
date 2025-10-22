/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        // code here
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast ){
                return countlength(slow);
            }
            
        }
        
        return 0; 
    }
    
    public static int countlength(Node node){
        Node temp = node;
        
        int count =1;
        
        while(temp.next != node){
            count++;
            temp = temp.next;
        }
        return count;
    }
}