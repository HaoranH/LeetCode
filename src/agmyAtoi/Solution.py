class Solution(object):
    def myAtoi(self, str):
        """
            :type str: str
            :rtype: int
            """
        str = str.strip()
        length = len(str)
        if length == 0: return 0
        i = 0
        flag = 1
        if str[0] == '-':
            flag = -1
            i += 1
        elif str[0] == '+':
            i += 1
        retVal = 0
        for x in xrange(i,length):
            if str[x].isdigit():
                retVal = retVal*10 + int(str[x])
                if retVal > 2147483647:
                    return 2147483647 if flag == 1 else(2147483648)*flag
            else: break
        return int(retVal*flag)