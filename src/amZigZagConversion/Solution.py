class Solution(object):
    def convert(self, s, numRows):
        """
            :type s: str
            :type numRows: int
            :rtype: str
            """
        if numRows<2:
            return s
        retStr = ""
        retList = [[] for _ in xrange(numRows)]
        unitLen = 2*(numRows-1)
        for i in xrange(len(s)):
            unitNum = i%unitLen
            index = unitNum if unitNum<numRows else unitLen-unitNum
            retList[index].append(s[i])
        for j in xrange(len(retList)):
            for char in retList[j]:
                retStr += char
        return retStr
