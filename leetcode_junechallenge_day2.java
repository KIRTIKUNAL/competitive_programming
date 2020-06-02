// Delete Node in a Linked List
/*
* Input: head = [4,5,1,9], node = 5
* Output: [4,1,9]
* Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        
        /*
         * We use the trick : We copy the value of second node into first.delete the second node and 
         * connect the first node to third.
         */
        
        //copy the second node's value in the first node 
        int temp = node.next.val;
        node.val = temp;
        
        //store the referennce of third node
        ListNode nxt = node.next.next;
        
        //free the second node to make it eligible for GC.
        node.next = null;
        
        //connect the first node with third node.
        node.next = nxt;
        
        
    }
}
