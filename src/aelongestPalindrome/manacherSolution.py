# http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-ii.html

class Solution(object):
    def longestPalindrome(self, s):
        """
            :type s: str
            :rtype: str
            """
        if(len(s) == 0 or len(s) == 1 or len(s) == 2):
            return s
        T = "#"
        for i in xrange(len(s)):
            T += s[i]
            T += "#"
        P = [0]*len(T)
        R = 1
        C = 1
        retStr = ""
        max = 0
        for i in xrange(1,len(T)-1):
            image = 2*C - i
            P[i] = min(P[image],R-i)
            while i-1-P[i] >= 0 and i+1+P[i] < len(T) and (T[i-1-P[i]] == T[i+1+P[i]]):
                P[i] += 1
            if P[i] > max:
                max = P[i]
                retStr = s[(i-P[i])/2:(i+1+P[i])/2]
            if P[i] > R-i:
                C = i
                    R = i+P[i]
                return retStr