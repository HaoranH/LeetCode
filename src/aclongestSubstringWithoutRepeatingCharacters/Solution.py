class Solution:
    # @param {string} s
    # @return {integer}
    def lengthOfLongestSubstring(self, s):
        start = 0
        result = 0
        subStr = ''
        for i in xrange(len(s)):
            if s[i] not in subStr:
                subStr += s[i]
            else:
                result = max(result, i - start)
                while s[start] != s[i]:start+=1
                start+=1
                subStr = s[start:i+1]
        result = max(result,len(s)-start)
        return result