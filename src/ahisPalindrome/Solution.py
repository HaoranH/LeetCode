class Solution(object):
    def isPalindrome(self, x):
        """
            :type x: int
            :rtype: bool
            """
        if x < 0: return False
        digit = 1
        while x/digit >= 10:
            digit *= 10
        while x != 0:
            left = x/digit
            right = x % 10
            if left != right: return False
            x = (x%digit)/10
            digit /= 100
        return True