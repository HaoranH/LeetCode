package abaddTwoNumbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int digit = 0;
        ListNode l3 = new ListNode(0);
        ListNode t1 = l1, t2 = l2, t3 = l3;
        
        while(t1 != null || t2 != null){
            if(t1 != null){
                digit += t1.val;
                t1 = t1.next;
            }
            
            if(t2 != null){
                digit += t2.val;
                t2 = t2.next;
            }
            
            t3.next = new ListNode(digit%10);
            t3 = t3.next;
            digit /= 10;
            
            if(digit == 1){
                t3.next = new ListNode(1);
            }
        }
        return l3.next;
    }
}