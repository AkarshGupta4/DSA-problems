/*
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}*/

class Solution {
    public int getCount(Node head) {
        // code here
        int count =0; 
        
        while(head != null){
            
            count++;
            head = head.next;
        }
        return count;
    }
}