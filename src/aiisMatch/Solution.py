class Solution:
    # @return a boolean
    # This works, but time complexity is high
    # This solution takes the advantage of python string slicing.
    def isMatch(self, s, p):
        if not p: return not s
        if p[-1] == '*':
            if self.isMatch(s,p[:-2]):
                return True
            if s and (s[-1] == p[-2] or p[-2] == '.') and self.isMatch(s[:-1],p):
                return True
        elif s and (s[-1] == p[-1] or p[-1] == '.') and self.isMatch(s[:-1],p[:-1]):
            return True
        return False
    
test = Solution()

test.isMatch("aa","a*")