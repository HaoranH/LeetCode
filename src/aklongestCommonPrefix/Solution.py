class Solution(object):
    def longestCommonPrefix(self, strs):
        """
            :type strs: List[str]
            :rtype: str
            """
        if not strs: return ""
        if len(strs) == 1: return strs[0]
        if not strs[0]: return ""
        else:
            for i in xrange(len(strs)-1):
                pointer = 0
                minLen = min(len(strs[i]),len(strs[i+1]))
                while(pointer<minLen and strs[i][pointer] == strs[i+1][pointer]):
                    pointer+=1
                strs[i+1] = strs[i+1][0:pointer]
            return strs[-1]
