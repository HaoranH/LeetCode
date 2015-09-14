class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        length = len(s)
        retStr = ""
        if length == 0 or length == 1 or length == 2:
            return s
        for n in xrange(length):
            tmpStr = ""
            tmpStr = self.checkPalindrome(s,n,n+1)
            if len(tmpStr) > len(retStr): 
                retStr = tmpStr
            tmpStr = self.checkPalindrome(s,n-1,n+1)
            if len(tmpStr) > len(retStr):
                retStr = tmpStr
        return retStr
    def checkPalindrome(self,s,start,end):
        while start >= 0 and end <= len(s)-1 and s[start] == s[end]:
            start -= 1
            end += 1
        return s[start+1:end]