# -*- coding: utf-8 -*-
"""
Created on Wed Sep 16 10:42:45 2015
"""
# This is not exactly my code, since I got confused at the overflow issue. 
# For python, once the value of int type overflows the variable turn into long
# type, which, IMO, deprives the necessity of the 'difficulty' and 
# in this case, lessened the meaning of solving it in python.
class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        retVal = 0
        if x < 0:
            flag = -1
            x *= -1
        while x:
            # Python's modulo operator (%) always
            # return a number having the same sign as the denominator (divisor)
            # Thus the operator before the value must be determined.
            retVal = retVal * 10 + x % 10  
            x = x / 10
        if retVal > 2 ** 31 / 10:
            return 0
        return retVal * flag