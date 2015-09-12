# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param {ListNode} l1
    # @param {ListNode} l2
    # @return {ListNode}
    def addTwoNumbers(self, l1, l2):
        
        digit = 0
        t1 = l1
        t2 = l2
        l3 = ListNode(0)
        t3 = l3
        while t1 != None or t2 != None:
            if t1 != None:
                digit = digit + t1.val
                    t1 = t1.next
            
                if t2 != None:
                    digit = digit + t2.val
                        t2 = t2.next
        
                t3.next = ListNode(digit%10)
                t3 = t3.next
                digit = digit/10
                
                if digit == 1:
                    t3.next = ListNode(1)
                        return l3.next